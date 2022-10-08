package pl.niepracuj.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
    @Operation(summary = "Get all technologies", tags = "technology")
    public List<TechnologyDto> getTechnologies(){
        return technologyService.getAllTechnologies();
    }

    @PostMapping("/create")
    @Operation(summary = "Create new technology", tags = "technology")
    @Parameter(name = "name", description = "technology name")
    public TechnologyDto createLevel(@RequestBody TechnologyDto technologyDto){
        return technologyService.createTechnology(technologyDto);
    }
}
