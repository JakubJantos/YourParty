package pl.jakubJantos.YourParty;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/homePage")
public class YourPartyControler {

    @GetMapping
    String homePage(){
        return "homePage";
    }
}
