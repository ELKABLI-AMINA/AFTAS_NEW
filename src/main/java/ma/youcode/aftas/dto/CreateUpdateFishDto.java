package ma.youcode.aftas.dto;

public record CreateUpdateFishDto(
        String name,
        double averageWeight,
        Long levelId
) {
}
