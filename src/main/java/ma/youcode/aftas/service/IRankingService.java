package ma.youcode.aftas.service;

import ma.youcode.aftas.dto.CreateUpdateRankingDto;
import ma.youcode.aftas.model.Ranking;

public interface IRankingService {
    Ranking getRankingById(Long id);
//    Ranking updateRanking(Ranking ranking, Long id);
//    Ranking updateRankingScore(Ranking ranking, Long id);
//    void deleteRanking(Long id);
    Ranking save(CreateUpdateRankingDto createUpdateRankingDto);
}
