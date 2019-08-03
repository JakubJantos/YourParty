package pl.jakubJantos.YourParty.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserControler {

    private final UserServices userServices;

    public UserControler(UserServices userServices){
        this.userServices = userServices;
    }

    @GetMapping("/registration")
    public String User(){
        return "user/registration";
    }

    @PostMapping("/registration")
    public String register (@RequestParam String mail, @RequestParam String login, @RequestParam String password, Model model){

        boolean reg = userServices.register(mail,login,password);
        model.addAttribute("register", reg);

        return "user/registration";
    }
}
