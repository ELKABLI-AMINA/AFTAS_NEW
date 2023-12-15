package ma.youcode.aftas.service.impl;

import lombok.RequiredArgsConstructor;
import ma.youcode.aftas.entities.Ranking;
import ma.youcode.aftas.repository.RankingRepository;
import ma.youcode.aftas.service.IRankingService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RankingServiceImpl implements IRankingService {
    private final RankingRepository rankingRepository;
    private final MemberServiceImpl memberService;
    private final CompetitionServiceImpl competitionService;
    @Override
    public Ranking getRankingsByMemberNumAndCompetitionId(Long competitionId, Integer memberNum) {
        memberService.findByNum(memberNum);
        competitionService.getCompetitionById(competitionId);
        Ranking ranking =rankingRepository.findByMemberNumAndCompetitionId(memberNum,competitionId);
        if (ranking == null) {
            throw new RuntimeException("Member inum" + memberNum + " has not participated in competition id " + competitionId);
        }
        return ranking;
    }

    @Override
    public Ranking getRankingById(Long id)
    {
        return rankingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ranking id " + id + " not found"));
    }

    @Override
    public Ranking updateRanking(Ranking ranking, Long id) {
        Ranking existingRanking = getRankingById(id);
        existingRanking.setRank((ranking.getRank()));
        existingRanking.setScore(ranking.getScore());
        return rankingRepository.save(existingRanking);
    }

    @Override
    public Ranking updateRankingScore(Ranking ranking, Long id) {
        Ranking existingRanking = getRankingById(id);
        existingRanking.setScore(ranking.getScore()+existingRanking.getScore());
        return rankingRepository.save(existingRanking);
    }

    @Override
    public void deleteRanking(Long id) {
        getRankingById(id);
        rankingRepository.deleteById(id);

    }
}
