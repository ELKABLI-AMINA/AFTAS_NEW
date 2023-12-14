package ma.youcode.aftas.service;

import ma.youcode.aftas.entity.Competition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICompetitionService {
    Competition save(Competition competition);

    Optional<Competition> findByCode(String code);

}
