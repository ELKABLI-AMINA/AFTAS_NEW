package ma.youcode.aftas.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class CompetitionResponseDto {
    Long id;
    String code;

    LocalDate date;

    LocalTime  startTime;

    LocalTime  endTime;

    Integer numberOfParticipants;

    String location;

    Double amount;

}
