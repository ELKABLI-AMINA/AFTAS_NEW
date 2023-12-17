package ma.youcode.aftas.service;

import ma.youcode.aftas.model.Level;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IlevelService {

    Level create(Level level);
    void deleteLevelById(Long id);
    Level findLevelById(Long id);
    Boolean existsById(Long id);

}
