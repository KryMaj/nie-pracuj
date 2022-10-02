package pl.niepracuj.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.niepracuj.model.dto.CompanyDto;
import pl.niepracuj.service.CompanyService;

import java.util.List;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {


    private final CompanyService companyService;


    @GetMapping("/all")
    public List<CompanyDto> getCompanies(){
        return companyService.getAllCompanies();
    }

    @PostMapping("/create")
    public CompanyDto createCompany(@RequestBody CompanyDto companyDto){
        return companyService.createCompany(companyDto);
    }

}
