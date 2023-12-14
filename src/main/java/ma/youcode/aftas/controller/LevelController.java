package ma.youcode.aftas.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.youcode.aftas.dto.CreateUpdateLevelDto;
import ma.youcode.aftas.dto.response.LevelResponseDto;
import ma.youcode.aftas.entity.Level;
import ma.youcode.aftas.service.ILevelService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("api/levels")
public class LevelController {
    private final ILevelService levelService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<LevelResponseDto> createLevel(@Validated @RequestBody CreateUpdateLevelDto createUpdateLevelDto) {
        Level levelEntity = modelMapper.map(createUpdateLevelDto, Level.class);
        LevelResponseDto createdLevel = modelMapper.map(levelService.save(levelEntity), LevelResponseDto.class);
        return ResponseEntity.created(URI.create("/api/levels/" + createdLevel.getId())).body(createdLevel);
    }
    @PutMapping("/{id}")
    public ResponseEntity<LevelResponseDto> updateLevel(@PathVariable Long id, @Validated @RequestBody CreateUpdateLevelDto createUpdateLevelDto) {
        Level levelEntity = modelMapper.map(createUpdateLevelDto, Level.class);
        LevelResponseDto updatedLevel = modelMapper.map(levelService.update(levelEntity, id), LevelResponseDto.class);
        return ResponseEntity.ok(updatedLevel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LevelResponseDto> getLevel(@PathVariable Long id) {
        Optional<LevelResponseDto> level = levelService.findById(id).map(entity -> modelMapper.map(entity, LevelResponseDto.class));
        return level.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Page<LevelResponseDto>> getAllLevels(Pageable pageable) {
        Page<LevelResponseDto> levels = levelService.getAllLevel(pageable).map(entity -> modelMapper.map(entity, LevelResponseDto.class));
        return ResponseEntity.ok(levels);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLevel(@PathVariable Long id) {
        if (levelService.delete(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
