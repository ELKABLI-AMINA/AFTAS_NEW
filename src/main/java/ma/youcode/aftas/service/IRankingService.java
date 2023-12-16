package ma.youcode.aftas.service;

import ma.youcode.aftas.dto.CreateUpdateRankingDto;
import ma.youcode.aftas.model.Ranking;

public interface IRankingService {

    Ranking save(CreateUpdateRankingDto createUpdateRankingDto);
}
