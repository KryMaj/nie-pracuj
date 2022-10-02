package pl.niepracuj.model.mapper;

import org.springframework.stereotype.Component;
import pl.niepracuj.model.dto.CompanyDto;
import pl.niepracuj.model.entity.Company;

@Component
public class CompanyMapper {

   public CompanyDto toDto(Company company){
        return CompanyDto.builder()
                .id(company.getId())
                .email(company.getEmail())
                .size(company.getSize())
                .address(company.getAddress())
                .name(company.getName())
                .build();
    }

   public Company toNewEntity(CompanyDto companyDto){
        return Company.builder()
                .email(companyDto.getEmail())
                .size(companyDto.getSize())
                .address(companyDto.getAddress())
                .name(companyDto.getName())
                .build();
    }

}
