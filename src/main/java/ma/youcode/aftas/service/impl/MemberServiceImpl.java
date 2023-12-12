package ma.youcode.aftas.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.youcode.aftas.dto.CreateUpdateMemberDto;
import ma.youcode.aftas.dto.response.MemberResponseDto;
import ma.youcode.aftas.entity.Member;
import ma.youcode.aftas.exception.ConcurrentUpdateException;
import ma.youcode.aftas.exception.DatabaseAccessException;
import ma.youcode.aftas.exception.InvalidDataException;
import ma.youcode.aftas.repository.MembreRepository;
import ma.youcode.aftas.service.IMemberService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class MemberServiceImpl implements IMemberService {
    private final MembreRepository membreRepository;
    private final ModelMapper modelMapper;
    @Override
    public MemberResponseDto save(CreateUpdateMemberDto memberDto) {
        log.info("Attempting to save member:{}",memberDto);
        try{
            return Optional.ofNullable(memberDto)
                    .map(dto->modelMapper.map(dto, Member.class))
                    .map(membreRepository::save)
                    .map(savedMember->modelMapper.map(savedMember,MemberResponseDto.class))
                    .orElseThrow(()->new InvalidDataException("Invalid member data"));

        }catch(Exception ex){
            log.error("Unable to process input data",ex);
            throw new InvalidDataException("An error occurred while saving the member", ex);
        }



    }

    @Override
    public MemberResponseDto update(CreateUpdateMemberDto memberDto, Long id) {
        log.info("Attempting to update member with id {}: {}", id, memberDto);
        try{
            Member existingMember =membreRepository.findById(id).orElseThrow(()->new NoSuchElementException("No member found with id:" +id));
            modelMapper.map(memberDto, existingMember);
            Member updatedMember = membreRepository.save(existingMember);
            return modelMapper.map(updatedMember, MemberResponseDto.class);
        }catch( Exception ex){
            log.error("A concurrent update was detected while updating member with id {}", id, ex);
            throw new ConcurrentUpdateException("A concurrent update was detected. Please try again.", ex);
        }
    }

    @Override
    public Page<MemberResponseDto> findAll(Pageable pageable) {
        log.info("Fetching all members");
        try{
            return membreRepository.findAll(pageable)
                    .map(member -> modelMapper.map(member,MemberResponseDto.class));
        }catch(Exception ex){
            log.error("Unable to fetch all members", ex);
            throw new DatabaseAccessException("Unable to process request", ex);
        }
    }

    @Override
    public boolean delete(Long id) {
        log.info("Attempting to delete member with id: {}", id);
        try {
            membreRepository.findById(id)
                    .ifPresent(membreRepository::delete);

        }catch(Exception ex){
            log.error("Unable to delete member with id {}", id, ex);
            throw new NoSuchElementException("No member found with id: " + id);
        }
        return true;
    }
    public Optional<MemberResponseDto> findByName(String name){
        log.info("Fetching member by name: {}", name);
        try{
            return  membreRepository.findByName(name).
                    map(member -> modelMapper.map(member, MemberResponseDto.class));
        }catch(Exception ex){
            log.error("Unable to fetch member by name {}", ex);
            throw new DatabaseAccessException("Unable to process request", ex);
        }
    }
    public Optional<MemberResponseDto>findByNumber(int number){
        log.info("Fetching member by number: {}", number);
        try{
            return membreRepository.findByNum(number)
                    .map(member -> modelMapper.map(member, MemberResponseDto.class));
        }catch(Exception ex){
            log.error("Unable to fetch member by number {}", number, ex);
            throw new DatabaseAccessException("Unable to process request", ex);
        }
    }

    @Override
    public Optional<MemberResponseDto> findById(Long id) {
        return Optional.empty();
    }

}
