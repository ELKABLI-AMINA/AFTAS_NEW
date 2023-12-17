package ma.youcode.aftas.service;

import ma.youcode.aftas.model.Fish;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IFishService {
    Page<Fish> findAll(Pageable pageable);

    Fish save(Fish fish);

    void delete(Long id);

    Optional<Fish> findByName(String name);
    Optional<Fish> findById(Long id);
}
