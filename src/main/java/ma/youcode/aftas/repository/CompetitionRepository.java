package ma.youcode.aftas.repository;

import ma.youcode.aftas.entities.Competition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompetitionRepository extends JpaRepository<Competition, Long> {
     Optional<Competition> findByCode(String code);
}