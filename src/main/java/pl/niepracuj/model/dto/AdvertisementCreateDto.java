package pl.niepracuj.model.dto;

import lombok.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdvertisementCreateDto {


    private String name;

    private Instant expireDate;

    private Integer salaryFrom;

    private Integer salaryTo;

    private String description;

    private Long companyId;

    private Long technologyId;

    private Long seniorityId;

    private Long cityId;

    private Set<SkillsCreateDto> skills;
}
