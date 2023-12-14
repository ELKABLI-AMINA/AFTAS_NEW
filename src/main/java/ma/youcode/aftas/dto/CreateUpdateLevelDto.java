package ma.youcode.aftas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateUpdateLevelDto {
    @NotNull(message = "Code cannot be null")
    private int code;
    @NotBlank(message = "Description cannot be blank")
    private String description;
    @NotNull(message = "Points cannot be null")
    private int points;

    public CreateUpdateLevelDto(int code, String description, int points) {
        this.code = code;
        this.description = description;
        this.points = points;
    }
}
