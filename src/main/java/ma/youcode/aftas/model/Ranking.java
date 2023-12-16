package ma.youcode.aftas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ranking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Integer rank;
    private Integer score;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    @ManyToOne
    @JoinColumn(name = "competition_id")
    private Competition competition;

    public Ranking(Integer rank, Integer score, Member member, Competition competition) {
        this.rank = rank;
        this.score = score;
        this.member = member;
        this.competition = competition;
    }
}
