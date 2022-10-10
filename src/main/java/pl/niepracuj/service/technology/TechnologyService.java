package pl.niepracuj.service.technology;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.niepracuj.model.dto.TechnologyDto;

import javax.transaction.Transactional;
import java.util.List;

public interface TechnologyService {
    List<TechnologyDto> getAllTechnologies();

    TechnologyDto createTechnology(TechnologyDto technologyDto);
}
