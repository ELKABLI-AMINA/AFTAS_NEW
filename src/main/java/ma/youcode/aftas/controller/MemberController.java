package ma.youcode.aftas.controller;

import lombok.RequiredArgsConstructor;
import ma.youcode.aftas.dto.CreateUpdateMemberDto;
import ma.youcode.aftas.dto.response.MemberResponseDto;
import ma.youcode.aftas.service.IMemberService;
import ma.youcode.aftas.service.impl.MemberServiceImpl;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/members")
@RequiredArgsConstructor

public class MemberController {

    private final IMemberService memberService;

    @PostMapping
    public ResponseEntity<MemberResponseDto> createMember(@Validated @RequestBody CreateUpdateMemberDto memberDto){
       MemberResponseDto createdMember = memberService.save(memberDto);
       return ResponseEntity.ok(createdMember);
    }


}
