package ma.youcode.aftas.service;

import ma.youcode.aftas.entity.Fish;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IFishService {
    Page<Fish> findAll(Pageable pageable);

    Fish save(Fish fish);

    void delete(Long id);

    Optional<Fish> findByName(String name);
}
