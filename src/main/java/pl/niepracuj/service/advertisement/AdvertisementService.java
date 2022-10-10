package pl.niepracuj.service.advertisement;

import org.springframework.data.domain.Pageable;
import pl.niepracuj.model.dto.AdvertisementCreateDto;
import pl.niepracuj.model.dto.AdvertisementDto;
import pl.niepracuj.model.dto.AdvertisementSearchCriteriaDto;

import java.util.List;

public interface AdvertisementService {
    public List<AdvertisementDto> getAllAdvertisements();


    public List<AdvertisementDto> getAllAdvertisementsForCompany(Long id);



    public List<AdvertisementDto> getAdvertisementsByCriteria(AdvertisementSearchCriteriaDto criteriaDto, Pageable pageable);

    AdvertisementDto createAdvertisement(AdvertisementCreateDto createDto);


}
