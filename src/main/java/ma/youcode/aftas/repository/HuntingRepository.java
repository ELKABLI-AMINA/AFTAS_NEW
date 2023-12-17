package ma.youcode.aftas.repository;

import ma.youcode.aftas.model.Competition;
import ma.youcode.aftas.model.Fish;
import ma.youcode.aftas.model.Hunting;
import ma.youcode.aftas.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HuntingRepository extends JpaRepository<Hunting,Long> {

  //  Optional<Hunting> findByCompetitionAndMemberAndFish(Competition competition, Member member, Fish fish);
}
