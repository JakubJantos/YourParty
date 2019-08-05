package pl.jakubJantos.YourParty.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserControler {

    private final UserServices userServices;

    public UserControler(UserServices userServices) {
        this.userServices = userServices;
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
            List<User> users = userServices.findAll();
            model.addAttribute("users", users);

            return "user/registration";
        }catch (Exception ex){
            model.addAttribute("ERROR", ex.getLocalizedMessage());
            return "user/registration";
        }
    }

    @GetMapping("/login")
    public String loginForm(){
        return "user/login";
    }


    @PostMapping("/login")
    public String login(@RequestParam String login, @RequestParam String password, Model model) {
        try {


            boolean log = userServices.login(login, password);
            model.addAttribute("login", log);

            return "user/controlPanel";

        }catch (Exception ex){
            model.addAttribute("badLogin", ex.getLocalizedMessage());
            return "user/login";
        }
    }
}
