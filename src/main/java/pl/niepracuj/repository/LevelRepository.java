package pl.niepracuj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.niepracuj.model.entity.Level;

@Repository
public interface LevelRepository extends JpaRepository<Level, Long> {
}
