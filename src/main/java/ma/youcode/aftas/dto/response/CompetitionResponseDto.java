package ma.youcode.aftas.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Date;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public final class CompetitionResponseDto {
    Long id;
    String code;

    Date date;

    LocalTime  startTime;

    LocalTime  endTime;

    Integer numberOfParticipants;

    String location;

    Double amount;

}
