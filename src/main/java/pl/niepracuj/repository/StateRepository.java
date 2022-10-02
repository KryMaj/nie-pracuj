package pl.niepracuj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.niepracuj.model.entity.Seniority;
import pl.niepracuj.model.entity.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
}
