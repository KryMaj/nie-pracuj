package pl.niepracuj.model.dto;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdvertisementCreateDto {
    @Size(max = 250, message = "Size can't be bigger than 250 characters")
    @NotBlank(message = "Name is mandatory")
    private String name;
    @Future(message = "Expire date can't be less than current date")
    @DateTimeFormat(pattern = "yyyy-MM-ddThh:mm:ss")
    private LocalDateTime expireDate;
    @NotNull(message = "Salary from is mandatory")
    @Min(value = 0, message = "Salary from must be 0 or more")
    private Integer salaryFrom;
    @NotNull(message = "Salary to is mandatory")
    @Min(value = 0, message = "Salary from must be 0 or more")
    private Integer salaryTo;
    @NotBlank(message = "Description is mandatory")
    private String description;
    @NotNull(message = "Company id is mandatory")
    private Long companyId;
    @NotNull(message = "Technology id is mandatory")
    private Long technologyId;
    @NotNull(message = "Seniority id is mandatory")
    private Long seniorityId;
    @NotNull(message = "City id is mandatory")
    private Long cityId;

    private Set<SkillCreateDto> skills;
}
