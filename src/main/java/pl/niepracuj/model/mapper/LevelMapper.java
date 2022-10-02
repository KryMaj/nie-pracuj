package pl.niepracuj.model.mapper;

import org.springframework.stereotype.Component;
import pl.niepracuj.model.dto.LevelDto;
import pl.niepracuj.model.entity.Level;
@Component
public class LevelMapper {
    public LevelDto toDto(Level level) {
        return LevelDto.builder()
                .id(level.getId())
                .name(level.getName())
                .score(level.getScore())
                .build();
    }

    public Level toNewEntity(LevelDto levelDto) {
        return Level.builder()
                .name(levelDto.getName())
                .score(levelDto.getScore())
        .build();
    }
}
