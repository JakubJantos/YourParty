package pl.jakubJantos.YourParty.Events;

import pl.jakubJantos.YourParty.User.User;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String localization;
    private LocalDate eventDate;
    private String eventStatus;

    @ManyToOne
    private User user;

    public Events() {
    }

    public Events(String name, String localization, LocalDate eventDate, String eventStatus, User user) {
        this.name = name;
        this.localization = localization;
        this.eventDate = eventDate;
        this.eventStatus = eventStatus;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocalization() {
        return localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
