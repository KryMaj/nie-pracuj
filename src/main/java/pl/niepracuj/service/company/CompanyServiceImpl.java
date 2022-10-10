package pl.niepracuj.service.company;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.niepracuj.model.dto.CompanyDto;
import pl.niepracuj.model.mapper.CompanyMapper;
import pl.niepracuj.repository.CompanyRepository;
import pl.niepracuj.service.company.CompanyService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor

public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;
    @Override
    public List<CompanyDto> getAllCompanies() {
        return companyRepository.findAll().stream()
                .map(companyMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CompanyDto createCompany(CompanyDto companyDto) {

        return companyMapper.toDto(companyRepository.save(companyMapper.toNewEntity(companyDto)));

    }
}
