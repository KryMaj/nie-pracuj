package pl.niepracuj.model.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.niepracuj.model.dto.ApplicationCreateDto;
import pl.niepracuj.model.dto.ApplicationDto;
import pl.niepracuj.model.entity.Application;
@Component
@RequiredArgsConstructor
public class ApplicationMapper {


    public Application toNewEntity(ApplicationCreateDto applicationCreateDto) {
        return Application.builder()
                .name(applicationCreateDto.getName())
                .surname(applicationCreateDto.getSurname())
                .email(applicationCreateDto.getEmail())
                .introduction(applicationCreateDto.getIntroduction())
                .build();
    }

    public ApplicationDto toDto(Application application) {
        return ApplicationDto.builder()
                .id(application.getId())
                .introduction(application.getIntroduction())
                .path(application.getPath())
                .name(application.getName())
                .email(application.getEmail())
                .surname(application.getSurname())
                .build();
    }
}
