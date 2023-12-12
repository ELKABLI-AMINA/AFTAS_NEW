package ma.youcode.aftas.dto;

import lombok.Data;

@Data
public class CreateUpdateLevelDto {
    private int code;
    private String description;
    private int points;

    public CreateUpdateLevelDto(int code, String description, int points) {
        this.code = code;
        this.description = description;
        this.points = points;
    }
}
