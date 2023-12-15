package ma.youcode.aftas.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.youcode.aftas.dto.CreateUpdateCompetitionDto;
import ma.youcode.aftas.dto.response.CompetitionResponseDto;
import ma.youcode.aftas.entities.Competition;
import ma.youcode.aftas.service.ICompetitionService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/competitions")
@RequiredArgsConstructor
@Slf4j
public class CompetitionController {
    private final ICompetitionService competitionService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<CompetitionResponseDto> createCompetition(@Valid @RequestBody CreateUpdateCompetitionDto createCompetitionDto) {
        Competition createdCompetition = competitionService.save(modelMapper.map(createCompetitionDto, Competition.class));
        CompetitionResponseDto responseDto = modelMapper.map(createdCompetition, CompetitionResponseDto.class);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }



    @GetMapping("/{code}")
    public ResponseEntity<CompetitionResponseDto> getCompetitionById(@PathVariable String code) {
        return competitionService.findByCode(code)
                .map(competition -> ResponseEntity.ok(modelMapper.map(competition, CompetitionResponseDto.class)))
                .orElse(ResponseEntity.notFound().build());
    }





}
