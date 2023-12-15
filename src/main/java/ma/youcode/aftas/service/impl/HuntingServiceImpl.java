package ma.youcode.aftas.service.impl;

import lombok.RequiredArgsConstructor;
import ma.youcode.aftas.entities.Competition;
import ma.youcode.aftas.entities.Fish;
import ma.youcode.aftas.entities.Hunting;
import ma.youcode.aftas.entities.Member;
import ma.youcode.aftas.exception.ResourceNotFoundException;
import ma.youcode.aftas.repository.HuntingRepository;
import ma.youcode.aftas.service.IHuntingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HuntingServiceImpl implements IHuntingService {
    private HuntingRepository huntingRepository;
    private FishServiceImpl fishService;
    private MemberServiceImpl memberService;
    private CompetitionServiceImpl competitionService;

    @Override
    public Hunting getHuntingById(Long id) {
        return huntingRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No Hunting found with id:" + id));
    }

    @Override
    public Hunting addHuntingResult(Hunting hunting) {
        Long competionId = hunting.getCompetition().getId();
        Integer memberNum= hunting.getMember().getNum();
        Long fishId = hunting.getFish().getId();

        Competition competition = competitionService.getCompetitionById(competionId);
        Optional < Member> member= memberService.findByNum(memberNum);
        Fish fish =fishService.getFishById(fishId);


    }

    @Override
    public List<Hunting> getHuntingsByCompetition(Long competitionId) {
        return null;
    }

    @Override
    public List<Hunting> getHuntingsByCompetitionAndMember(Long competitionId, Long memberId) {
        return null;
    }

    @Override
    public Hunting updateHunting(Hunting hunting, Long id) {
        return null;
    }

    @Override
    public void deleteHunting(Long id) {

    }
}
