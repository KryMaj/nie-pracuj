package pl.niepracuj.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "advertisements")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDateTime publishDate;

    private LocalDateTime expireDate;

    private Integer salaryFrom;

    private Integer salaryTo;

    private String description;

    @ManyToOne
    Technology technology;

    @ManyToOne
    Seniority seniority;

    @ManyToOne
    private City city;

    @ManyToOne
    private Company company;

    @ManyToMany
    @JoinTable(
            name = "advSkills",
            joinColumns = @JoinColumn(name = "skill_id"),
            inverseJoinColumns = @JoinColumn(name = "adv_id")
    )
    Set<Skill> skills;


}
