package pl.niepracuj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.niepracuj.model.entity.Advertisement;
import pl.niepracuj.model.entity.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
