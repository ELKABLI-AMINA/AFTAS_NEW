package ma.youcode.aftas.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.youcode.aftas.dto.CreateUpdateCompetitionDto;
import ma.youcode.aftas.dto.response.CompetitionResponseDto;
import ma.youcode.aftas.entity.Competition;
import ma.youcode.aftas.service.ICompetitionService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/competitions")
@RequiredArgsConstructor

public class CompetitionController {
    private final ICompetitionService competitionService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<CompetitionResponseDto> createCompetition(@Valid @RequestBody CreateUpdateCompetitionDto createCompetitionDto) {
        Competition createdCompetition = competitionService.save(modelMapper.map(createCompetitionDto, Competition.class));
        CompetitionResponseDto responseDto = modelMapper.map(createdCompetition, CompetitionResponseDto.class);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompetitionResponseDto> updateCompetition(@PathVariable Long id, @Validated @RequestBody CreateUpdateCompetitionDto updateCompetitionDto) {
        Competition updatedCompetition = competitionService.update(modelMapper.map(updateCompetitionDto, Competition.class), id);
        CompetitionResponseDto responseDto = modelMapper.map(updatedCompetition, CompetitionResponseDto.class);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/{code}")
    public ResponseEntity<CompetitionResponseDto> getCompetitionById(@PathVariable String code) {
        return competitionService.findByCode(code)
                .map(competition -> ResponseEntity.ok(modelMapper.map(competition, CompetitionResponseDto.class)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Page<CompetitionResponseDto>> getAllCompetitions(Pageable pageable) {
        return ResponseEntity.ok(competitionService.findAll(pageable)
                .map(competition -> modelMapper.map(competition, CompetitionResponseDto.class)));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteCompetition(@PathVariable String code) {
        if (competitionService.delete(code)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
