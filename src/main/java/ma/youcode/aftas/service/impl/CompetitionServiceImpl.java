package ma.youcode.aftas.service.impl;

import lombok.RequiredArgsConstructor;
import ma.youcode.aftas.exception.ResourceNotFoundException;
import ma.youcode.aftas.model.Competition;
import ma.youcode.aftas.repository.CompetitionRepository;
import ma.youcode.aftas.service.ICompetitionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
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
    public Page<Competition> findAll(Pageable pageable) {
        return competitionRepository.findAll(pageable);
    }


    @Override
    public Optional<Competition> findByCode(String code) {
        return competitionRepository.findByCode(code);
    }

    @Override
    public Optional<Competition> findById(Long id) {
        return competitionRepository.findById(id);
    }

    @Override
    public Boolean existsById(String id) {
        return null;
    }

    @Override
    public Long countCompetitions() {
        return competitionRepository.count();
    }

    @Override
    public List<Competition> getAllCompetitions(Pageable pageable, String search, LocalDate date) {
        if(search != null && date != null){
            return competitionRepository.findAllByCodeContainingOrLocationContainingAndDateEquals(search,search,date,pageable).getContent();
        } else if(search != null){
            return competitionRepository.findAllByCodeContainingOrLocationContaining(search,search,pageable).getContent();
        } else if(date != null){
            return competitionRepository.findAllByDateEquals(date,pageable).getContent();
        }
        return competitionRepository.findAll(pageable).getContent();
    }


}
