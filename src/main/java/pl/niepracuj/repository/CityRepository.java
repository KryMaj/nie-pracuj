package pl.niepracuj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.niepracuj.model.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
