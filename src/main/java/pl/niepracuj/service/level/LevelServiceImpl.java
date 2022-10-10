package pl.niepracuj.service.level;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.niepracuj.model.dto.LevelDto;
import pl.niepracuj.model.mapper.LevelMapper;
import pl.niepracuj.repository.LevelRepository;
import pl.niepracuj.service.level.LevelService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class LevelServiceImpl implements LevelService {

    private final LevelRepository levelRepository;
    private final LevelMapper levelMapper;

    @Override
    public List<LevelDto> getAllLevels() {
        return levelRepository.findAll().stream()
                .map(level->levelMapper.toDto(level))
                .collect(Collectors.toList());
    }

    @Override
    public LevelDto createLevel(LevelDto levelDto) {
        return levelMapper.toDto(levelRepository.save(levelMapper.toNewEntity(levelDto)));
    }
}
