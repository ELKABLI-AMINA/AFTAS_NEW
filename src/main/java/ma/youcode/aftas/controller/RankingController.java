package ma.youcode.aftas.controller;

import lombok.RequiredArgsConstructor;
import ma.youcode.aftas.dto.CreateUpdateMemberDto;
import ma.youcode.aftas.dto.CreateUpdateRankingDto;
import ma.youcode.aftas.dto.response.MemberResponseDto;
import ma.youcode.aftas.dto.response.RankingResponseDto;
import ma.youcode.aftas.model.Member;
import ma.youcode.aftas.model.Ranking;
import ma.youcode.aftas.service.IRankingService;
import ma.youcode.aftas.service.impl.RankingServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
@CrossOrigin("*")
public class RankingController {
    private final IRankingService rankingService;
    private final ModelMapper modelMapper;
    @PostMapping
    public ResponseEntity<RankingResponseDto> createRanking(@Validated @RequestBody CreateUpdateRankingDto createRankingDto) {
        Ranking createdRanking = rankingService.save(createRankingDto);
        RankingResponseDto responseDto = modelMapper.map(createdRanking, RankingResponseDto.class);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }



}
