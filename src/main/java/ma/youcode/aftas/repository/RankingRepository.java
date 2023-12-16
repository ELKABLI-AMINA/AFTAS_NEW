package ma.youcode.aftas.repository;

import ma.youcode.aftas.model.Competition;
import ma.youcode.aftas.model.Member;
import ma.youcode.aftas.model.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RankingRepository extends JpaRepository<Ranking,Long> {
    Optional<Ranking> findByMemberAndCompetition(Member member, Competition competition);

}
