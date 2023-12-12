package ma.youcode.aftas.dto.response;

public record RankingResponseDto(
        long id,
        CompetitionResponseDto competition,
        MemberResponseDto member,
        int rank,
        int score
) {
}
