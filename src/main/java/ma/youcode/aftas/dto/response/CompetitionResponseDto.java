package ma.youcode.aftas.dto.response;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public final class CompetitionResponseDto {
    Long id;
    String code;

    Date date;
    LocalDateTime startTime;
    LocalDateTime endTime;

    Integer numberOfParticipants;

    String location;

    Double amount;
}
