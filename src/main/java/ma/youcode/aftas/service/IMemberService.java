package ma.youcode.aftas.service;

import ma.youcode.aftas.entities.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IMemberService {
    Member save(Member member);
    Member update(Member member, Integer num);
    Page<Member> findAll(Pageable pageable);
    boolean delete(Integer num);
    Optional<Member> findByNum(Integer num);
}
