package pl.niepracuj.service.advertisement;

import pl.niepracuj.model.dto.AdvertisementCreateDto;
import pl.niepracuj.model.dto.AdvertisementDto;
import pl.niepracuj.model.dto.AdvertisementSearchCriteriaDto;
import pl.niepracuj.model.dto.CompanyDto;

import java.util.List;

public interface AdvertisementService {
    public List<AdvertisementDto> getAllAdvertisements();

    public List<AdvertisementDto> getAdvertisementsByCriteria(AdvertisementSearchCriteriaDto criteriaDto);

    AdvertisementDto createAdvertisement(AdvertisementCreateDto createDto);


}
