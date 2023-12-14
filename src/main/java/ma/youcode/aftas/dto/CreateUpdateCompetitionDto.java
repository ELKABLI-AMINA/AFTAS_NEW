package ma.youcode.aftas.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Data
@Component

@NoArgsConstructor
public class CreateUpdateCompetitionDto {
    @NotNull
    String code;

    @NotNull
    @FutureOrPresent
    Date date;

    LocalDateTime  startTime;
    LocalDateTime  endTime;

    @Min(1)
    Integer numberOfParticipants;

    @NotBlank
    String location;

    @Min(0)
    Double amount;
    public CreateUpdateCompetitionDto(String code, Date date, LocalDateTime startTime, LocalDateTime endTime, Integer numberOfParticipants, String location, Double amount) {
        this.code = code;
        this.date = date;
        this.startTime = (startTime != null) ? startTime : LocalDateTime.now();

        // Vérifier si endTime est nul, sinon initialiser à une valeur par défaut
        if (endTime != null && this.startTime.isAfter(endTime)) {
            throw new IllegalArgumentException("L'heure de début doit être avant l'heure de fin");
        }

        this.endTime = (endTime != null) ? endTime : this.startTime.plusHours(1);
        this.numberOfParticipants = numberOfParticipants;
        this.location = location;
        this.amount = amount;
    }

}


