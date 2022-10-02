package pl.niepracuj.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.niepracuj.model.dto.LevelDto;
import pl.niepracuj.model.dto.TechnologyDto;
import pl.niepracuj.service.TechnologyService;

import java.util.List;

@RestController
@RequestMapping("/technology")
@RequiredArgsConstructor
public class TechnologyController {

    private final TechnologyService technologyService;

    @GetMapping("/all")
    public List<TechnologyDto> getTechnologies(){
        return technologyService.getAllTechnologies();
    }

    @PostMapping("/create")
    public TechnologyDto createLevel(@RequestBody TechnologyDto technologyDto){
        return technologyService.createTechnology(technologyDto);
    }
}
