package pl.niepracuj.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SkillCreateDto {

    private String name;

    private Long levelId;
}
