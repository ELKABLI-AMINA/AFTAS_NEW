package ma.youcode.aftas.service;

import ma.youcode.aftas.entities.Competition;

import java.util.Optional;

public interface ICompetitionService {
    Competition save(Competition competition);
    Competition getCompetitionById(Long id);
    Optional<Competition> findByCode(String code);

}
