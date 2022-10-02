package pl.niepracuj.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.niepracuj.model.dto.SeniorityDto;
import pl.niepracuj.model.mapper.SeniorityMapper;
import pl.niepracuj.repository.SeniorityRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
@RequiredArgsConstructor
public class SeniorityServiceImpl implements SeniorityService{

    private final SeniorityRepository seniorityRepository;

    private final SeniorityMapper seniorityMapper;

    @Override
    public SeniorityDto createSeniority(SeniorityDto seniorityDto) {
        return seniorityMapper.toDto(seniorityRepository.save(seniorityMapper.toNewEntity(seniorityDto)));
    }

    @Override
    public List<SeniorityDto> getAllSeniorities() {
        return seniorityRepository.findAll().stream()
                .map(seniority -> seniorityMapper.toDto(seniority))
                .collect(Collectors.toList());
    }
}
