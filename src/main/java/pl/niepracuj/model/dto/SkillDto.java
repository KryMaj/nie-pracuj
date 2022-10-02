package pl.niepracuj.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SkillDto {

    private Long id;

    private String address;

    private Long levelId;
}
