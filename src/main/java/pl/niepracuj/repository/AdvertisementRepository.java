package pl.niepracuj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.niepracuj.model.entity.Advertisement;

@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {
}
