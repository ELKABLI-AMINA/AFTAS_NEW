package ma.youcode.aftas.service.impl;

import lombok.RequiredArgsConstructor;
import ma.youcode.aftas.entity.Competition;
import ma.youcode.aftas.exception.ResourceNotFoundException;
import ma.youcode.aftas.repository.CompetitionRepository;
import ma.youcode.aftas.service.ICompetitionService;
import org.modelmapper.ValidationException;
import org.modelmapper.spi.ErrorMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor

public class CompetitionServiceImpl implements ICompetitionService {
    private final CompetitionRepository competitionRepository;
    @Override
    public Competition save(Competition competition) {
        if (competition.getDate().before(new Date())){
            throw new IllegalArgumentException("date must be after today");
        }
        if(competition.getStartTime().isAfter(competition.getEndTime())){
            throw new IllegalArgumentException("start time must be before end time");
        }

        if(findByCode(competition.getCode()).isPresent()){
            throw new IllegalArgumentException("Competition already exists with same code: " + competition.getCode());
        }
        long timeDifference = competition.getDate().getTime() - System.currentTimeMillis();
        long hoursDifference = TimeUnit.MILLISECONDS.toHours(timeDifference);
        if (hoursDifference < 24) {
            throw new IllegalArgumentException("La compétition doit être créée au moins 24 heures à l'avance.");
        }
        String locationCode = competition.getLocation().toLowerCase().replaceAll("\\s", "-");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yy-MM-dd");
        String dateCode = competition.getStartTime().format(dateFormatter);
        String competitionCode = locationCode + "-" + dateCode;
        competition.setCode(competitionCode);
        return competitionRepository.save(competition);
    }






    @Override
    public Optional<Competition> findByCode(String code) {
        return competitionRepository.findByCode(code);
    }



}
