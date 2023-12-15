package ma.youcode.aftas.repository;

import ma.youcode.aftas.entities.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankingRepository extends JpaRepository<Ranking,Long> {
    Ranking findByMemberNumAndCompetitionId(Integer memberNum, Long competitionId);

}
