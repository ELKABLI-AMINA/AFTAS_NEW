package ma.youcode.aftas.service.impl;

import lombok.RequiredArgsConstructor;
import ma.youcode.aftas.model.Competition;
import ma.youcode.aftas.exception.ResourceNotFoundException;
import ma.youcode.aftas.repository.CompetitionRepository;
import ma.youcode.aftas.service.ICompetitionService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class CompetitionServiceImpl implements ICompetitionService {
    private final CompetitionRepository competitionRepository;

    @Override
    public Competition save(Competition competition) {

        return competitionRepository.save(competition);


    }

    @Override
    public Competition getCompetitionById(Long id) {
        return competitionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Competition id " + id + " not found"));
    }


    @Override
    public Optional<Competition> findByCode(String code) {
        return competitionRepository.findByCode(code);
    }


}
