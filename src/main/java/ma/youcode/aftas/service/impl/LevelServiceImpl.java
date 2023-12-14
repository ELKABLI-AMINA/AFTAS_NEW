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
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
@Service
@RequiredArgsConstructor
@Slf4j
public class LevelServiceImpl implements ILevelService {
        private final LevelRepository levelRepository;



        @Override
        public Level save(Level level) {
                return Optional.ofNullable(level)
                        .map(levelRepository::save)
                        .orElseThrow(() -> new InvalidDataException("Invalid level data"));
        }

        @Override
        public Level update(Level level, Long id) {
                Level existingLevel = levelRepository.findById(id)
                        .orElseThrow(() -> new NoSuchElementException("No level found with id: " + id));
                return levelRepository.save(existingLevel);

        }

        @Override
        public Optional<Level> findById(Long id) {

                return levelRepository.findById(id);
        }

        @Override
        public Page<Level> getAllLevel(Pageable pageable) {

                return levelRepository.findAll(pageable);
        }

        @Override
        public boolean delete(Long id) {
                levelRepository.findById(id)
                        .ifPresent(levelRepository::delete);
                return true;
        }
}
