package ma.youcode.aftas.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class LevelResponseDto {
     long id;
    private Integer code;
    private String description;
    private Integer points;


}