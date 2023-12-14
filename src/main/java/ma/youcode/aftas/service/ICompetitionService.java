package ma.youcode.aftas.service;

import ma.youcode.aftas.entity.Competition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICompetitionService {
    Competition save(Competition competition);
    Competition update(Competition competitionDto, Long id);
    Optional<Competition> findByCode(String code);
    Page<Competition> findAll(Pageable pageable);
    boolean delete(String code);
}
