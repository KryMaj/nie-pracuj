package pl.niepracuj.service.application;

import org.springframework.data.domain.Pageable;
import pl.niepracuj.model.dto.*;

import java.io.IOException;
import java.util.List;

public interface ApplicationService {

ApplicationDto createApplication(ApplicationCreateDto applicationCreateDto) throws IOException;
}
