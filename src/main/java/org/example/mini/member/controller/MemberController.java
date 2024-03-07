package org.example.mini.member.controller;

import lombok.RequiredArgsConstructor;
import org.example.mini.member.dto.response.MemberResponse;
import org.example.mini.member.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

  private final MemberService memberService;

  @GetMapping()
  public List<MemberResponse> findAllMembers() {
    return this.memberService.findAllMembers();
  }
}
