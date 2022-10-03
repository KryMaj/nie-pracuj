package pl.niepracuj.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.niepracuj.model.dto.AdvertisementCreateDto;
import pl.niepracuj.model.dto.AdvertisementDto;
import pl.niepracuj.model.dto.CompanyDto;
import pl.niepracuj.service.advertisement.AdvertisementService;

import java.util.List;

@RestController
@RequestMapping("/adv")
@RequiredArgsConstructor
public class AdvertisementController {


    private final AdvertisementService advertisementService;


    @GetMapping("/all")
    public List<AdvertisementDto> getAdvertisements(){
        return advertisementService.getAllAdvertisements();
    }

    @PostMapping("/create")
    public AdvertisementDto createAdvertisement(@RequestBody AdvertisementCreateDto advertisementDto){
        return advertisementService.createAdvertisement(advertisementDto);
    }

}
