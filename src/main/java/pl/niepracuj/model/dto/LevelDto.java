package pl.niepracuj.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LevelDto {

    private Long id;

    private String name;

    private Integer score;
}
