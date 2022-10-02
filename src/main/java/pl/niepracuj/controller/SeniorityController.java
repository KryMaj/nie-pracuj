package pl.niepracuj.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.niepracuj.model.dto.SeniorityDto;
import pl.niepracuj.model.dto.TechnologyDto;
import pl.niepracuj.service.SeniorityService;
import pl.niepracuj.service.TechnologyService;

import java.util.List;
@RestController
@RequestMapping("/seniority")
@RequiredArgsConstructor
public class SeniorityController {



        private final SeniorityService seniorityService;

        @GetMapping("/all")
        public List<SeniorityDto> getSeniorities(){
            return seniorityService.getAllSeniorities();
        }

        @PostMapping("/create")
        public SeniorityDto createSeniority(@RequestBody SeniorityDto seniorityDto){
            return seniorityService.createSeniority(seniorityDto);
        }
}
