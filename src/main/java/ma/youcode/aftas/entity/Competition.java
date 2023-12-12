package ma.youcode.aftas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
public class Competition  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String code;
    private Date date;
    private LocalDate startTime;
    private LocalDate endTime;
    private Integer numberOfParticipants;
    private String location;
    private String amount;
    @OneToMany(mappedBy = "competition")
    private List<Ranking> rankings;
}