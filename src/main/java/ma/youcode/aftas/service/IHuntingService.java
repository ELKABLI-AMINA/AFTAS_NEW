package ma.youcode.aftas.service;

import ma.youcode.aftas.dto.CreateUpdateHuntingDto;
import ma.youcode.aftas.model.Hunting;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IHuntingService {
    Hunting save(CreateUpdateHuntingDto huntingDTO);



}
