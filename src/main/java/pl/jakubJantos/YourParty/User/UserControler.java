package pl.jakubJantos.YourParty.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.jakubJantos.YourParty.Events.EventsRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserControler {

    private final UserServices userServices;
    private final EventsRepository eventsRepository;
    private final UserRepository userRepository;

    public UserControler(UserServices userServices, EventsRepository eventsRepository, UserRepository userRepository) {
        this.userServices = userServices;
        this.eventsRepository = eventsRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/registration")
    public String User() {
        return "user/registration";
    }

    @PostMapping("/registration")
    public String register(@RequestParam String mail, @RequestParam String login, @RequestParam String password, Model model) {

        try {


            boolean reg = userServices.register(mail, login, password);
            model.addAttribute("register", reg);


            return "user/registration";
        } catch (Exception ex) {
            model.addAttribute("ERROR", ex.getLocalizedMessage());
            return "user/registration";
        }
    }

    @GetMapping("/login")
    public String loginForm() {
        return "user/login";
    }


    @PostMapping("/login")
    public String login(@RequestParam String login, @RequestParam String password, Model model, HttpServletRequest request) {
        try {


            User loggedUser = userServices.login(login, password);
            request.getSession().setAttribute("principalId", loggedUser.getId());


            return "redirect:/controlPanel/" + loggedUser.getId();

        } catch (Exception ex) {
            model.addAttribute("badLogin", ex.getLocalizedMessage());
            return "user/login";
        }
    }

    @GetMapping("/controlPanel/{id}")
    public String controlPanel(@PathVariable Long id, Model model) {

        model.addAttribute("userId", id);
        model.addAttribute("eventsL", eventsRepository.findByUserId(id));

        return "user/controlPanel";
    }

    @GetMapping("/listUsers")
    public String listUsers( Model model, @SessionAttribute Long principalId){

        if(principalId == null){
            throw new IllegalStateException("Access denied");
        }

        List<User> users = userServices.findAll();
        model.addAttribute("users", users);
        model.addAttribute("user", userRepository.findById(principalId));
        return "user/listUsers";
    }
}
