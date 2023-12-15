package ma.youcode.aftas.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.youcode.aftas.entities.Competition;
import ma.youcode.aftas.entities.Member;
import org.springframework.stereotype.Component;


@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public final class CreateUpdateRankingDto {
    @NotNull(message = "Rank cannot be null") @Min(value = 1, message = "Rank must be at least 1")
    private  Integer rank;
    @NotNull(message = "Score cannot be null") @Min(value = 0, message = "Score must be at least 0") @Max(value = 100, message = "Score must be at most 100")
    private   Integer score;
    @ManyToOne
    @JoinColumn(name = "member_id")
    @NotNull(message = "Member cannot be null")
    private  Member member;
    @ManyToOne
    @JoinColumn(name = "competition_id")
    @NotNull(message = "Competition cannot be null")
    private  Competition competition;



}
