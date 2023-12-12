package ma.youcode.aftas.service;

import ma.youcode.aftas.dto.CreateUpdateLevelDto;
import ma.youcode.aftas.dto.response.LevelResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ILevelService {
    LevelResponseDto save (CreateUpdateLevelDto  level);
    LevelResponseDto update (CreateUpdateLevelDto levelDto, Long id);
    Optional<LevelResponseDto> findById (Long id);
    Page<LevelResponseDto> getAllLevel (Pageable pageable);
    boolean delete(Long id);
}
