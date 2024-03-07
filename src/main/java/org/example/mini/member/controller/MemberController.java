package org.example.mini.member.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.mini.member.dto.request.MemberCreateRequest;
import org.example.mini.member.dto.response.MemberResponse;
import org.example.mini.member.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

  private final MemberService memberService;

  @PostMapping()
  public void createMember(@RequestBody @Valid MemberCreateRequest request) {
    this.memberService.createMember(request);
  }

  @GetMapping()
  public List<MemberResponse> findAllMembers() {
    return this.memberService.findAllMembers();
  }
}
