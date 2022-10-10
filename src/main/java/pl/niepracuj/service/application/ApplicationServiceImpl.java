package pl.niepracuj.service.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.niepracuj.exception.exceptions.EntityNotFoundException;
import pl.niepracuj.model.dto.ApplicationCreateDto;
import pl.niepracuj.model.dto.ApplicationDto;
import pl.niepracuj.model.entity.Application;
import pl.niepracuj.model.mapper.ApplicationMapper;
import pl.niepracuj.repository.AdvertisementRepository;
import pl.niepracuj.repository.ApplicationRepository;
import pl.niepracuj.service.file.FileService;

import javax.transaction.Transactional;
import java.io.IOException;

@Service
@Transactional
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final AdvertisementRepository advertisementRepository;
    private final ApplicationMapper applicationMapper;
    private final FileService fileService;


    @Override
    public ApplicationDto createApplication(ApplicationCreateDto applicationCreateDto) throws IOException {
        Application application = applicationMapper.toNewEntity(applicationCreateDto);
        application.setPath(fileService.saveFile(applicationCreateDto.getCv()));
        application.setAdvertisement(advertisementRepository.findById(applicationCreateDto.getAdvertisementId())
                .orElseThrow(() -> new EntityNotFoundException("Advertisement", applicationCreateDto.getAdvertisementId())));

        return applicationMapper.toDto(applicationRepository.save(application));
    }
}
