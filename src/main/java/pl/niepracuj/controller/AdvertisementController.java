package pl.niepracuj.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pl.niepracuj.model.dto.AdvertisementCreateDto;
import pl.niepracuj.model.dto.AdvertisementDto;
import pl.niepracuj.model.dto.AdvertisementSearchCriteriaDto;
import pl.niepracuj.model.dto.LogDto;
import pl.niepracuj.service.advertisement.AdvertisementService;
import pl.niepracuj.service.log.LogService;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/adv")
@RequiredArgsConstructor
public class AdvertisementController {




    private final AdvertisementService advertisementService;
    private final LogService logService;


    @GetMapping("/all")
    public List<AdvertisementDto> getAdvertisements() throws IOException, InterruptedException {
        var response = advertisementService.getAllAdvertisements();
//        logService.sendLog(new LogDto().getLogDto("Pobrano wszystkie ogloszenia"));

        return response;
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
