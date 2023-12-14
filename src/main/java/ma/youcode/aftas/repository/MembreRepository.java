package ma.youcode.aftas.repository;

import ma.youcode.aftas.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MembreRepository extends JpaRepository<Member,Integer> {

    Optional<Member> findByNum(Integer num);

}
