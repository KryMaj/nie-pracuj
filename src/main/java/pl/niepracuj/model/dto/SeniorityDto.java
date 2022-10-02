package pl.niepracuj.model.dto;

import lombok.*;
import pl.niepracuj.model.enums.SeniorityEnum;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeniorityDto {

    private Long id;

    private SeniorityEnum name;

}
