package ma.youcode.aftas.service;

import ma.youcode.aftas.entities.Competition;

import java.util.Optional;

public interface ICompetitionService {
    Competition save(Competition competition);

    Optional<Competition> findByCode(String code);

}
