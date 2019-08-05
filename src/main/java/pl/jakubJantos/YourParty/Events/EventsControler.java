package pl.jakubJantos.YourParty.Events;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class EventsControler {

    private EventsRepository eventsRepository;

    public EventsControler(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }


    @GetMapping ("/createEvent")
    String form(){
        return "Events/createEvent";
    }

    @PostMapping(value = "/createEvent", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    String createEvent(@RequestParam String name,
                       @RequestParam String localization,
                       @RequestParam String eventDate,
                       @RequestParam EventStatus eventStatus, Model model){

        LocalDate eDate = LocalDate.parse(eventDate);

        Events events = new Events(name,localization,eDate,eventStatus.name());
        eventsRepository.save(events);

        List<Events> userEvent = eventsRepository.findAll();
        model.addAttribute("events", userEvent);

        return "user/controlPanel";

    }
}
