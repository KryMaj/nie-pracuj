package pl.niepracuj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.niepracuj.model.entity.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
}
