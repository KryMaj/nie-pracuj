package pl.niepracuj.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "skills")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    private Long levelId;

    @ManyToMany(mappedBy = "skills")
    Set<Advertisement> advertisements;

    @ManyToOne
    private Level level;
}
