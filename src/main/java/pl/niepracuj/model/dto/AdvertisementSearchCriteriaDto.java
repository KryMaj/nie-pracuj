package pl.niepracuj.model.dto;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import pl.niepracuj.model.enums.SeniorityEnum;
import pl.niepracuj.model.enums.TechnologyEnum;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdvertisementSearchCriteriaDto {

    private String name;
    private Integer salaryFrom;
    private Integer salaryTo;
    private String companyName;
    private TechnologyEnum technologyName;
    private SeniorityEnum seniorityName;
    private String cityName;

}
