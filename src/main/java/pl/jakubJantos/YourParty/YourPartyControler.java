package pl.jakubJantos.YourParty;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody ("/HomePage")
public class YourPartyControler {

    @GetMapping("/HomePage")
    String(){
        return "HomePage";
    }
}
