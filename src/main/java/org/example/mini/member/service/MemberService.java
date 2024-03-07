package org.example.mini.member.service;

import lombok.RequiredArgsConstructor;
import org.example.mini.member.domain.MemberRepository;
import org.example.mini.member.dto.request.MemberCreateRequest;
import org.example.mini.member.dto.response.MemberResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;

  @Transactional()
  public void createMember(MemberCreateRequest request) {
    this.memberRepository.save(request.toEntity());
  }

  @Transactional(readOnly = true)
  public List<MemberResponse> findAllMembers() {
    return this.memberRepository
        .findAll()
        .stream()
        .map(MemberResponse::new)
        .toList();
  }
}
