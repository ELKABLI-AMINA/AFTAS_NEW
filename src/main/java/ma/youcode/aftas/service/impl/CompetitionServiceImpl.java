package ma.youcode.aftas.service.impl;

import lombok.RequiredArgsConstructor;
import ma.youcode.aftas.entity.Competition;
import ma.youcode.aftas.repository.CompetitionRepository;
import ma.youcode.aftas.service.ICompetitionService;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor

public class CompetitionServiceImpl implements ICompetitionService {
    private final CompetitionRepository competitionRepository;

    @Override
    public Competition save(Competition competition) {
        return competitionRepository.save(competition);


    }


    @Override
    public Optional<Competition> findByCode(String code) {
        return competitionRepository.findByCode(code);
    }


}
