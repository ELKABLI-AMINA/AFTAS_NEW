package ma.youcode.aftas.service;

import ma.youcode.aftas.entities.Ranking;

public interface IRankingService {
    Ranking getRankingsByMemberNumAndCompetitionId(Long competitionId, Integer memberNum);
    Ranking getRankingById(Long id);
    Ranking updateRanking(Ranking ranking, Long id);
    Ranking updateRankingScore(Ranking ranking, Long id);
    void deleteRanking(Long id);
}
