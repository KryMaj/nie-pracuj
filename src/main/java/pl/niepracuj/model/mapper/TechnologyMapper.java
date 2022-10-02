package pl.niepracuj.model.mapper;

import org.springframework.stereotype.Component;
import pl.niepracuj.model.dto.TechnologyDto;
import pl.niepracuj.model.entity.Technology;
@Component
public class TechnologyMapper {
    public TechnologyDto toDto(Technology technology) {
        return TechnologyDto.builder()
                .id(technology.getId())
                .name(technology.getName())
                .build();
    }

    public Technology toNewEntity(TechnologyDto technologyDto) {
        return Technology.builder()
                .name(technologyDto.getName())
                .build();
    }
}
