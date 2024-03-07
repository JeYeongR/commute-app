package org.example.mini.member.service;

import lombok.RequiredArgsConstructor;
import org.example.mini.member.domain.MemberRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;
}
