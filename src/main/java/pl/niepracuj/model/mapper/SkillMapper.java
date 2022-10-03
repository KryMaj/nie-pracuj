package pl.niepracuj.model.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.niepracuj.model.dto.CityDto;
import pl.niepracuj.model.dto.SkillDto;
import pl.niepracuj.model.dto.SkillsCreateDto;
import pl.niepracuj.model.entity.City;
import pl.niepracuj.model.entity.Skill;

@Component
@RequiredArgsConstructor
public class SkillMapper {

    private final LevelMapper levelMapper;

    public SkillDto toDto(Skill skill) {
        return SkillDto.builder()
                .id(skill.getId())
                .name(skill.getName())
                .level(levelMapper.toDto(skill.getLevel()))
                .build();
    }


    public Skill toNewEntity(SkillsCreateDto skillsCreateDto) {
        return Skill.builder()
                .name(skillsCreateDto.getName())
                .build();
    }
}
