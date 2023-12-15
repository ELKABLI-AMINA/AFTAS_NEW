package ma.youcode.aftas.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public final class RankingResponseDto {
    long id;
     CompetitionResponseDto competition;
     MemberResponseDto member;
     Integer rank;
     Integer score;



}
