package ma.youcode.aftas.service;

import ma.youcode.aftas.dto.CreateUpdateMemberDto;
import ma.youcode.aftas.dto.response.MemberResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IMemberService {
    MemberResponseDto save(CreateUpdateMemberDto memberDto);
    MemberResponseDto update(CreateUpdateMemberDto memberDto, Long id);
    Page<MemberResponseDto> findAll(Pageable pageable);
    boolean delete(Long id);
    Optional<MemberResponseDto> findById(Long id);
}
