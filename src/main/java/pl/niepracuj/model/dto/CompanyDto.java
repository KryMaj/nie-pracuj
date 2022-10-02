package pl.niepracuj.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyDto {
    private Long id;

    private String name;

    private String address;

    private Integer size;
}
