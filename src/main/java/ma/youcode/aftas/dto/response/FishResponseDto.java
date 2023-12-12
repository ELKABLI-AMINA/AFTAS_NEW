package ma.youcode.aftas.dto.response;

public record FishResponseDto(
        Long id,
        int num,
        String name,
        double averageWeight,
        LevelResponseDto level
) {
}
