package ma.youcode.aftas.service.impl;

import lombok.RequiredArgsConstructor;
import ma.youcode.aftas.dto.CreateUpdateHuntingDto;
import ma.youcode.aftas.exception.FishWeightException;
import ma.youcode.aftas.exception.InvalidDataException;
import ma.youcode.aftas.model.*;
import ma.youcode.aftas.exception.ResourceNotFoundException;
import ma.youcode.aftas.repository.HuntingRepository;
import ma.youcode.aftas.service.IFishService;
import ma.youcode.aftas.service.IHuntingService;
import ma.youcode.aftas.service.IMemberService;
import ma.youcode.aftas.service.IRankingService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HuntingServiceImpl implements IHuntingService {
    private HuntingRepository huntingRepository;
    private IFishService fishService;
    private IMemberService memberService;
    private IRankingService rankingService;
    private CompetitionServiceImpl competitionService;
 /*  public Hunting save(CreateUpdateHuntingDto huntingDTO){
        Optional<Competition> competition=competitionService.findById(huntingDTO.getCompetitionId());
        Optional<Member> member=memberService.findByNum(huntingDTO.getMemberNum());
        Optional<Fish> fish=fishService.findById(huntingDTO.getFishId());
        if(competition.isPresent()){
            if(member.isEmpty()){
                throw new ResourceNotFoundException("this member doesn't exist");
            }else{
                if(fish.isEmpty()){
                    throw new ResourceNotFoundException("this fish doesn't exist");
                }else{
                    Date competitionDate = competition.get().getDate();
                    LocalTime competitionStartTime=competition.get().getStartTime();
                    LocalTime competitionStartDate=LocalTime.of(competitionDate,competitionStartTime);

                    LocalTime endOfDayTime = LocalTime.of(23, 59, 59);
                    LocalDateTime competitionEndDateTime = LocalDateTime.of(competitionStartDate, competitionStartTime);
                    if(competitionStartTime.isAfter(LocalDateTime.now())){
                        throw new InvalidDataException("the competition didn't begin yet");
                    }else{
                        if(competitionDayEnd.isBefore(LocalDateTime.now())){
                            throw new  InvalidDataException("the day of the competition is over ");
                        }else{
                            RankingId rankingId=RankingId.builder()
                                    .competitionId(competition.get().getId())
                                    .memberId(member.get().getId())
                                    .build();
                            Optional<Ranking> ranking=rankingService.findById(rankingId);
                            if(ranking.isEmpty()){
                                throw  new ResourceNotFoundException("this member doesn't exist in the competition , added first");
                            }else{
                                Optional<Hunting> hunting=huntingRepository.findByCompetitionAndMemberAndFish(competition.get(),member.get(),fish.get());
                                double fishWeight= huntingDTO.getFishWeight();
                                System.out.println(fishWeight);
                                double fishAverageWeight=fish.get().getAverageWeight();
                                System.out.println(fishAverageWeight);
                                if(hunting.isEmpty()){
                                    if(fishWeight>fishAverageWeight || fishWeight ==fishAverageWeight){
                                        Hunting addedHunting=new Hunting(1,competition.get(),fish.get(),member.get());
                                        Hunting modifiedHunting=huntingRepository.save(addedHunting);

                                        Ranking foundRanking=ranking.get();
                                        Integer  currentScore=foundRanking.getScore();
                                        Integer  fishPoints=fish.get().getLevel().getPoints();
                                        Integer  newScore=currentScore+fishPoints;
                                        foundRanking.setScore(newScore);
                                        rankingService.saveValidRanking(foundRanking);

                                        return modifiedHunting;

                                    }else{
                                        throw new FishWeightException("the weight of the fish is lower than average ");
                                    }
                                }else{
                                    if(fishWeight>fishAverageWeight || fishWeight ==fishAverageWeight){
                                        Hunting foundHunting=hunting.get();
                                        int currentNumberOfFish =foundHunting.getNumberOfFish();
                                        int newNumberOfFish=currentNumberOfFish+1;
                                        foundHunting.setNumberOfFish(newNumberOfFish);
                                        Hunting modifiedHunting =huntingRepository.save(foundHunting);

                                        Ranking foundRanking=ranking.get();
                                        Integer  currentScore=foundRanking.getScore();
                                        Integer  fishPoints=fish.get().getLevel().getPoints();
                                        Integer  newScore=currentScore+fishPoints;
                                        foundRanking.setScore(newScore);

                                        rankingService.saveValidRanking(foundRanking);

                                        return modifiedHunting;
                                    }else{
                                        throw new FishWeightException("the weight of the fish is lower than average ");
                                    }

                                }
                            }
                        }
                    }
                }

            }

        }else{
            throw new ResourceNotFoundException("this competition doesn't exist");
        }
    }



  */

}

