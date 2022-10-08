package pl.niepracuj.model.dto;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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
    private String technologyName;
    private String seniorityName;
    private String cityName;

}
