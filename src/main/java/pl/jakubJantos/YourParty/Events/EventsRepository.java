package pl.jakubJantos.YourParty.Events;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;
import java.util.List;

//@Entity
public interface EventsRepository extends JpaRepository<Events, Long> {

    List<Events> findByUserId(Long userId);
}
