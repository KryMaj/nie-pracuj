package pl.niepracuj.service;

import pl.niepracuj.model.dto.LevelDto;

import java.util.List;

public interface LevelService {
    List<LevelDto> getAllLevels();

    LevelDto createLevel(LevelDto levelDto);
}
