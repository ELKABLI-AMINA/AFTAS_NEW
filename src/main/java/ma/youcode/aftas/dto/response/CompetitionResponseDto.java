package ma.youcode.aftas.dto.response;

import java.time.LocalDateTime;
import java.util.Date;

public record CompetitionResponseDto(
        Long id,
        String code,
        Date date,
        LocalDateTime startTime,
        LocalDateTime endTime,
        int numberOfParticipants,
        String location,
        double amount
) {
}
