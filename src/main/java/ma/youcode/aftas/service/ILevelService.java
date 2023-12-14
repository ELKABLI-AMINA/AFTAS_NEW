package ma.youcode.aftas.service;

import ma.youcode.aftas.dto.CreateUpdateLevelDto;
import ma.youcode.aftas.dto.response.LevelResponseDto;
import ma.youcode.aftas.entity.Level;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ILevelService {
    Level save(Level level);
    Level update(Level level, Long id);
    Optional<Level> findById(Long id);
    Page<Level> getAllLevel(Pageable pageable);
    boolean delete(Long id);
}
