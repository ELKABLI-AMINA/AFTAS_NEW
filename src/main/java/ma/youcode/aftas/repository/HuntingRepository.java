package ma.youcode.aftas.repository;

import ma.youcode.aftas.model.Hunting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HuntingRepository extends JpaRepository<Hunting,Long> {
}
