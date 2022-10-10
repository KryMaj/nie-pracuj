package pl.niepracuj.service.technology;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.niepracuj.model.dto.TechnologyDto;
import pl.niepracuj.model.mapper.TechnologyMapper;
import pl.niepracuj.repository.TechnologyRepository;
import pl.niepracuj.service.technology.TechnologyService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class TechnologyServiceImpl implements TechnologyService {

    private final TechnologyRepository technologyRepository;

    private final TechnologyMapper technologyMapper;
    @Override
    public List<TechnologyDto> getAllTechnologies() {
        return technologyRepository.findAll().stream()
                .map(technology -> technologyMapper.toDto(technology))
                .collect(Collectors.toList());
    }

    @Override
    public TechnologyDto createTechnology(TechnologyDto technologyDto) {
        return technologyMapper.toDto(technologyRepository.save(technologyMapper.toNewEntity(technologyDto)));
    }
}
