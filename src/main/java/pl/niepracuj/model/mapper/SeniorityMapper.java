package pl.niepracuj.model.mapper;

import org.springframework.stereotype.Component;
import pl.niepracuj.model.dto.SeniorityDto;
import pl.niepracuj.model.entity.Seniority;
@Component
public class SeniorityMapper {
    public  SeniorityDto toDto(Seniority seniority) {
        return SeniorityDto.builder()
                .id(seniority.getId())
                .name(seniority.getName())
                .build();
    }


    public Seniority toNewEntity(SeniorityDto seniorityDto) {
        return Seniority.builder()
                .name(seniorityDto.getName())
                .build();

    }
}
