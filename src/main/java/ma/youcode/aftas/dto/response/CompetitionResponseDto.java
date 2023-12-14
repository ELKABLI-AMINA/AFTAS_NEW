package ma.youcode.aftas.dto.response;

import java.time.LocalDateTime;
import java.util.Date;

public final class CompetitionResponseDto {
    Long id;
    String code;
    Date date;
    LocalDateTime startTime;
    LocalDateTime endTime;
    Integer numberOfParticipants;
    String location;
    double amount;
}
