package ma.youcode.aftas.service.impl;

import lombok.RequiredArgsConstructor;
import ma.youcode.aftas.exception.ResourceNotFoundException;
import ma.youcode.aftas.model.Level;
import ma.youcode.aftas.repository.LevelRepository;
import ma.youcode.aftas.service.IlevelService;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class levelServiceImpl implements IlevelService {
    private final LevelRepository levelRepository;


    @Override
    public Level create(Level level) {
        level = levelRepository.save(level);
        return setCodeForAllLevels(level);
    }

    @Override
    public void deleteLevelById(Long id) {
        if(existsById(id)){
            levelRepository.deleteById(id);
            setCodeForAllLevels(null);
        }else {
            throw new ResourceNotFoundException("Level does not exist");
        }

    }

    @Override
    public Level findLevelById(Long id) {
        return null;
    }

    @Override
    public List<Level> getAllLevels(Pageable pageable) {
        return null;
    }

    @Override
    public Boolean existsById(Long id) {
        return levelRepository.existsById(id);
    }
    public Level setCodeForAllLevels(Level level){
        List<Level> levels = levelRepository.findAllByOrderByPointsAsc();

        for(Integer i=0;i<levels.size();i++){
            levels.get(i).setCode(i+1);

        }
        levelRepository.saveAll(levels);
        if(level==null){
            return null;
        }
        return findLevelById(level.getId());
    }
}
