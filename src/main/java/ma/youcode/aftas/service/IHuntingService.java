package ma.youcode.aftas.service;

import ma.youcode.aftas.entities.Hunting;

import java.util.List;

public interface IHuntingService {
    Hunting getHuntingById(Long id);
    Hunting addHuntingResult(Hunting hunting);
    List<Hunting> getHuntingsByCompetition(Long competitionId);
    List<Hunting> getHuntingsByCompetitionAndMember(Long competitionId, Long memberId);
    Hunting updateHunting(Hunting hunting, Long id);
    void deleteHunting(Long id);

}
