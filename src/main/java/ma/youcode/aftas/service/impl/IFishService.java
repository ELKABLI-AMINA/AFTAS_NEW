package ma.youcode.aftas.service.impl;

import ma.youcode.aftas.entity.Fish;

import java.util.List;

public interface IFishService {
     Fish addFish(Fish fish) ;
     List<Fish> getAllFish();
     Fish getFishById(Long id);
}
