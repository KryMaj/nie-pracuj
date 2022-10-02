package pl.niepracuj.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "companies")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private Integer size;



}
