package pl.jakubJantos.YourParty.Events;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.jakubJantos.YourParty.User.User;
import pl.jakubJantos.YourParty.User.UserRepository;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

@Controller
public class EventsControler {

    private EventsRepository eventsRepository;
    private UserRepository userRepository;
    private EventsServices eventsServices;

    public EventsControler(EventsRepository eventsRepository, UserRepository userRepository, EventsServices eventsServices) {
        this.eventsRepository = eventsRepository;
        this.userRepository = userRepository;
        this.eventsServices = eventsServices;
    }

    @GetMapping ("/createEvent")
    String form(){
        return "Events/createEvent";
    }

    @PostMapping(value = "/createEvent", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    String createEvent(@RequestParam String name,
                       @RequestParam String localization,
                       @RequestParam String eventDate,
                       @RequestParam EventStatus eventStatus, Model model,
                       @SessionAttribute Long principalId){
        if(principalId == null){
            throw new IllegalStateException("Access denied");
        }
        User user = userRepository.findById(principalId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        LocalDate eDate = LocalDate.parse(eventDate);

        Events events = new Events(name,localization,eDate,eventStatus.name(), user);
        eventsRepository.save(events);

        return "redirect:/controlPanel/"+principalId;

    }

    @GetMapping("/Events/delete")
    public String deleteEvent(@RequestParam Long eventId, Model model, @SessionAttribute Long principalId) {

        if(principalId == null){
            throw new IllegalStateException("Access denied");
        }
        Events event =eventsRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("event not exist"));
        eventsRepository.delete(event);
        model.addAttribute("deleteEvent", eventsRepository.findAll());
        model.addAttribute("deleteStatus", true);

        return "redirect:/controlPanel/"+principalId;

    }

    @GetMapping("/eventEdit")
    String editForm(){
        return "Events/eventEdit";
    }

    @GetMapping("/eventsEdit/{eventId}")
    public String editEvent(@PathVariable Long eventId, Model model) {

//        if(principalId == null){
//            throw new IllegalStateException("Access denied");
//        }
        Events event = eventsRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("there in no event"));
        model.addAttribute("eventEdit", event);

        return "Events/eventEdit";
    }

    @PostMapping(value = "/eventEdit/{eventId}/save", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String savaEdit(@PathVariable Long eventId, @RequestParam String name,
                           @RequestParam String localization, @RequestParam String eventDate,
                           @RequestParam EventStatus eventStatus, Model model, @SessionAttribute Long principalId){

        if(principalId == null){
            throw new IllegalStateException("Access denied");
        }

        LocalDate eDate = LocalDate.parse(eventDate);

        eventsServices.edit(eventId, name, localization, eDate, eventStatus);
        model.addAttribute("saveEdit", eventsRepository.findAll());

        return "redirect:/controlPanel/"+principalId;
    }
}
