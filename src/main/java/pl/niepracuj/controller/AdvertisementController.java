package pl.niepracuj.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pl.niepracuj.model.dto.AdvertisementCreateDto;
import pl.niepracuj.model.dto.AdvertisementDto;
import pl.niepracuj.model.dto.AdvertisementSearchCriteriaDto;
import pl.niepracuj.service.advertisement.AdvertisementService;

import javax.validation.Valid;
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

    @GetMapping("/all/company/{companyid}")
    public List<AdvertisementDto> getAdvertisementsForUser(@PathVariable Long companyid){
        return advertisementService.getAllAdvertisementsForCompany(companyid);
    }

    @PostMapping("/create")
    public AdvertisementDto createAdvertisement(@RequestBody @Valid AdvertisementCreateDto advertisementDto){
        return advertisementService.createAdvertisement(advertisementDto);
    }

    @PostMapping("/search")
    public List<AdvertisementDto> searchAdvertisementByCriteria(@RequestBody AdvertisementSearchCriteriaDto criteriaDto,
                                                                Pageable pageable){
return advertisementService.getAdvertisementsByCriteria(criteriaDto, pageable);
    }

}
