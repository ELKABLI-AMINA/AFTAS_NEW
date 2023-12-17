package ma.youcode.aftas.service;

import ma.youcode.aftas.dto.CreateUpdateHuntingDto;
import ma.youcode.aftas.model.Hunting;

import java.util.List;

public interface IHuntingService {
    Hunting save(CreateUpdateHuntingDto huntingDTO);

}
