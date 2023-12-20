package ma.youcode.aftas.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.youcode.aftas.dto.CreateUpdateCompetitionDto;
import ma.youcode.aftas.dto.response.CompetitionResponseDto;
import ma.youcode.aftas.dto.response.FishResponseDto;
import ma.youcode.aftas.dto.response.MemberResponseDto;
import ma.youcode.aftas.model.Competition;
import ma.youcode.aftas.service.ICompetitionService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/competitions")
@RequiredArgsConstructor
@CrossOrigin("*")
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

    @GetMapping

    public ResponseEntity<List<CompetitionResponseDto>> getAllCompetitions(Pageable pageable) {
        return ResponseEntity.ok( competitionService.findAll(pageable)
                .stream()
                .map(competition -> modelMapper.map(competition, CompetitionResponseDto.class)).collect(Collectors.toList()));
    }
    @GetMapping("/count")
    public ResponseEntity countCompetitions(){
        Long count = competitionService.countCompetitions();
        return ResponseEntity.ok(count);

    }





}
