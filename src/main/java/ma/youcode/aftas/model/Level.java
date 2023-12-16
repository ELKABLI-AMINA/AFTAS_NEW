package ma.youcode.aftas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Level  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Integer code;
    private String description;
    private Integer points;


}
