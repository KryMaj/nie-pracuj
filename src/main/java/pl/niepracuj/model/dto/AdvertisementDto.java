package pl.niepracuj.model.dto;

import lombok.*;

import java.sql.Timestamp;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdvertisementDto {

    private Long id;

    private String name;

    private Long companyId;

    private Long technologyId;

    private Long seniorityId;

    private Long cityId;

    private Timestamp publishDate;

    private Timestamp expireDate;

    private Integer salaryFrom;

    private Integer salaryTo;

    private String description;
}
