package pl.niepracuj.model.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "applications")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Application {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private String email;

    private String introduction;

    private String path;

    @ManyToOne
    private Advertisement advertisement;
}
