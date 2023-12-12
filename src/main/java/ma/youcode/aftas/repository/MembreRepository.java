package ma.youcode.aftas.repository;

import ma.youcode.aftas.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MembreRepository extends JpaRepository<Member,Long> {
    Optional<Member> findByNum(Integer num);
    Optional<Member> findByName(String name);
}
