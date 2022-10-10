package pl.niepracuj.service.seniority;

import pl.niepracuj.model.dto.SeniorityDto;

import java.util.List;

public interface SeniorityService {
    SeniorityDto createSeniority(SeniorityDto seniorityDto);

    List<SeniorityDto> getAllSeniorities();
}
