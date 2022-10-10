package pl.niepracuj.model.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationCreateDto {

    private String name;

    private String surname;

    private String email;

    private String introduction;

    private MultipartFile cv;

    private Long advertisementId;
}

