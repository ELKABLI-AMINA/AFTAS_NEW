package ma.youcode.aftas.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.youcode.aftas.dto.CreateUpdateLevelDto;
import ma.youcode.aftas.dto.response.LevelResponseDto;
import ma.youcode.aftas.service.ILevelService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("api/levels")
public class LevelController {
    private final ILevelService levelService;

    @PostMapping
    public ResponseEntity<LevelResponseDto> createLevel(@RequestBody @Validated CreateUpdateLevelDto levelDto){
        log.info("Creating a new level: {}", levelDto);
         LevelResponseDto createdLevel = levelService.save(levelDto);
         return ResponseEntity.ok(createdLevel);

    }
}
