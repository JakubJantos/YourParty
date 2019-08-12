package pl.jakubJantos.YourParty.Events;


import org.springframework.stereotype.Service;

import java.awt.*;
import java.time.LocalDate;

@Service
public class EventsServices {

    private final EventsRepository eventsRepository;

    public EventsServices(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }


    public Events edit(long eventid, String name, String localization, LocalDate eventDate, EventStatus eventStatus) {

        Events events = eventsRepository.findById(eventid).get();
        events.setName(name);
        events.setLocalization(localization);
        events.setEventDate(eventDate);
        events.setEventStatus(eventStatus.name());

        return eventsRepository.save(events);
    }

}
