package pl.jakubJantos.YourParty.Events;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;

//@Entity
public interface EventsRepository extends JpaRepository<Events, Long> {

}
