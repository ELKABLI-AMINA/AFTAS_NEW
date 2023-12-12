package ma.youcode.aftas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
public class Hunting extends BaseEntity{
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
