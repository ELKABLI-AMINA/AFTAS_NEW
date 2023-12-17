package ma.youcode.aftas.service;

import ma.youcode.aftas.model.Competition;

import java.util.Optional;

public interface ICompetitionService {
    Competition save(Competition competition);
    Competition getCompetitionById(Long id);
    Optional<Competition> findByCode(String code);
    Optional<Competition> findById(Long id);

}
