package org.example.mini.member;

import lombok.RequiredArgsConstructor;
import org.example.mini.member.service.MemberService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

  private final MemberService memberService;
}
