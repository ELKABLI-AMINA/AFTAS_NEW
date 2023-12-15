package ma.youcode.aftas.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
public class Hunting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Integer nomberOfFish;
    @ManyToOne
    private Competition competition;
    @ManyToOne
    private Fish fish;
    @ManyToOne
    private Member member;

}
