package ma.youcode.aftas.service.impl;

import lombok.RequiredArgsConstructor;
import ma.youcode.aftas.model.Fish;
import ma.youcode.aftas.exception.ResourceAlreadyExistsException;
import ma.youcode.aftas.exception.ResourceNotFoundException;
import ma.youcode.aftas.model.Level;
import ma.youcode.aftas.repository.FishRepository;
import ma.youcode.aftas.service.IFishService;
import ma.youcode.aftas.service.IlevelService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class FishServiceImpl implements IFishService {
    private final FishRepository fishRepository;
    private final IlevelService levelService;
    @Override
    public Fish save(Fish fish) {
        if (fish.getLevel() != null) {
            Level level = levelService.findLevelById(fish.getLevel().getId());
            fish.setLevel(level);
        }

        if (fishRepository.findByName(fish.getName()).isPresent()) {
            throw new ResourceAlreadyExistsException("Fish with name " + fish.getName() + " already exists");
        }

        return fishRepository.save(fish);
    }


    @Override
    public Page<Fish> findAll(Pageable pageable) {
        return fishRepository.findAll(pageable);
    }


    @Override
    public void delete(Long id) {
        Optional<Fish> existingFish= fishRepository.findById(id);
        if(existingFish.isPresent()){
            fishRepository.delete(existingFish.get());
        }else {
            throw new NoSuchElementException("Fish with ID " + id + " not found");
        }

    }

    @Override
    public Optional<Fish> findByName(String name) {

        return fishRepository.findByName(name);
    }

    @Override
    public Optional<Fish> findById(Long id) {
        return fishRepository.findById(id);
    }




}
