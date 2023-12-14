package ma.youcode.aftas.dto;


import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class CreateUpdateCompetitionDto {
    @NotBlank
    String code;
    @NotNull @FutureOrPresent
    LocalDateTime date;
    @NotNull
    LocalDateTime startTime;
    @NotNull LocalDateTime endTime;
    @Min(1)
    Integer numberOfParticipants;
    @NotBlank
    String location;
    @Min(0)
    Double amount;
}
