package pl.niepracuj.model.dto;

import lombok.*;
import pl.niepracuj.model.entity.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdvertisementDto {


    private Long id;

    private String name;

    private LocalDateTime publishDate;

    private LocalDateTime expireDate;

    private Integer salaryFrom;

    private Integer salaryTo;

    private String description;


    private TechnologyDto technology;


    private SeniorityDto seniority;


    private CityDto city;


    private CompanyDto company;


   private  Set<SkillDto> skills;

}
