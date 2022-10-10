package pl.niepracuj.service.company;

import pl.niepracuj.model.dto.CompanyDto;

import java.util.List;

public interface CompanyService {
    public List<CompanyDto> getAllCompanies();

    CompanyDto createCompany(CompanyDto companyDto);
}
