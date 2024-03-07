package org.example.mini.member.service;

import lombok.RequiredArgsConstructor;
import org.example.mini.common.exception.ConflictException;
import org.example.mini.common.exception.NotFoundException;
import org.example.mini.member.domain.Member;
import org.example.mini.member.domain.MemberRepository;
import org.example.mini.member.dto.request.MemberCreateRequest;
import org.example.mini.member.dto.response.MemberResponse;
import org.example.mini.team.domain.Team;
import org.example.mini.team.domain.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;
  private final TeamRepository teamRepository;

  @Transactional
  public void createMember(MemberCreateRequest request) {
    Member member = request.toEntity();

    Team foundTeam = this.teamRepository.findByName(request.teamName())
        .orElseThrow(() -> new NotFoundException("NOT_FOUND_TEAM"));

    if (request.isManager() && foundTeam.hasManager()) {
      throw new ConflictException("ALREADY_EXIST_MANAGER");
    }

    member.joinTeam(foundTeam);
    this.memberRepository.save(member);
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
