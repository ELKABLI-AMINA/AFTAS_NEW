package ma.youcode.aftas.service.impl;

import lombok.RequiredArgsConstructor;
import ma.youcode.aftas.entity.Member;
import ma.youcode.aftas.exception.ResourceNotFoundException;
import ma.youcode.aftas.repository.MembreRepository;
import ma.youcode.aftas.service.IMemberService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements IMemberService {
    private final MembreRepository membreRepository;
    @Override
    public Member save(Member member) {
        MemberExiste(member);
        return membreRepository.save(member);
    }

    @Override
    public Member update(Member member, Integer num) {
        Member existingMember = membreRepository.findByNum(num)
                .orElseThrow(() -> new ResourceNotFoundException("Membre introuvable avec le numéro " + num));
         if(!existingMember.getNum().equals(member.getNum())){
             throw new IllegalArgumentException("Identity number cannot be changed");
         }
         return membreRepository.save(member);
    }

    @Override
    public Page<Member> findAll(Pageable pageable)
    {
        return membreRepository.findAll(pageable);
    }

    @Override
    public boolean delete(Integer num) {
        Optional<Member> memberOptional = membreRepository.findByNum(num);

        if (memberOptional.isPresent()) {
            membreRepository.delete(memberOptional.get());
            return true;
        } else {
            throw new ResourceNotFoundException("Membre introuvable avec le numéro " + num);
        }

    }

    @Override
    public Optional<Member> findByNum(Integer num) {
        return membreRepository.findByNum(num);
    }

    private void MemberExiste(Member member) {
        Optional<Member> existingMember = membreRepository.findByNum(member.getNum());

        if (existingMember.isPresent()) {
            throw new IllegalArgumentException("Member with the same number already exists");
        }
    }
}
