package ma.youcode.aftas.service.impl;

import lombok.RequiredArgsConstructor;
import ma.youcode.aftas.dto.CreateUpdateRankingDto;
import ma.youcode.aftas.exception.InvalidDataException;
import ma.youcode.aftas.exception.ResourceAlreadyExistsException;
import ma.youcode.aftas.model.Competition;
import ma.youcode.aftas.model.Member;
import ma.youcode.aftas.model.Ranking;
import ma.youcode.aftas.repository.RankingRepository;
import ma.youcode.aftas.service.IRankingService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RankingServiceImpl implements IRankingService {
    private final RankingRepository rankingRepository;
    private final MemberServiceImpl memberService;
    private final CompetitionServiceImpl competitionService;

    @Override
    public Ranking save(CreateUpdateRankingDto rankingDto) {
        Optional<Member> foundMemberOptional = memberService.findByNum(rankingDto.getMemberNum());
        if (foundMemberOptional.isEmpty()) {
            throw new InvalidDataException("this member doesn't exist added it first");
        } else {
            Optional<Competition> foundCompetition = competitionService.findById(rankingDto.getId());
            if (foundCompetition.isEmpty()) {
                throw new InvalidDataException("this competition doesn't exist added it first");
            } else {
                Optional<Ranking> foundRanking = rankingRepository.findByMemberAndCompetition(foundMemberOptional.get(), foundCompetition.get());
                System.out.println(foundRanking.isPresent());
                if (foundRanking.isPresent()) {
                    throw new ResourceAlreadyExistsException("this member is already in this competition");
                } else {
                    Ranking addedRanking = new Ranking(0, 0, foundMemberOptional.get(), foundCompetition.get());
                    return rankingRepository.save(addedRanking);
                }

            }

        }

    }


}
