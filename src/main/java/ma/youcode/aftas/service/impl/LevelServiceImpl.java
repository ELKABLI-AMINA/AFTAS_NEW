package ma.youcode.aftas.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.youcode.aftas.dto.CreateUpdateLevelDto;
import ma.youcode.aftas.dto.response.LevelResponseDto;
import ma.youcode.aftas.entity.Level;
import ma.youcode.aftas.exception.InvalidDataException;
import ma.youcode.aftas.repository.LevelRepository;
import ma.youcode.aftas.service.ILevelService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
@Slf4j
public class LevelServiceImpl implements ILevelService {
        private final LevelRepository levelRepository;
        private final ModelMapper modelMapper;
    @Override
    public LevelResponseDto save(CreateUpdateLevelDto level) {
        log.info("Attempting to save level: {}",level);
        try{
            return Optional.ofNullable(level).map(dto->modelMapper
                    .map(dto , Level.class))
                    .map(levelRepository::save)
                    .map(savedlevel->modelMapper
                            .map(savedlevel , LevelResponseDto.class ))
                    .orElseThrow(()->new InvalidDataException("Invalid leveldate"));
        }catch(Exception ex){
            log.error("Unable to process input date", ex);
            throw  new InvalidDataException("An error occurred while saving the level", ex);
        }
    }

    @Override
    public LevelResponseDto update(CreateUpdateLevelDto levelDto, Long id) {
        return null;
    }

    @Override
    public Optional<LevelResponseDto> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Page<LevelResponseDto> getAllLevel(Pageable pageable) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
