package org.example.mini.member.dto.response;

import org.example.mini.member.domain.Member;
import org.example.mini.member.domain.MemberRole;

import java.time.LocalDate;

public record MemberResponse(
    String name,
    String teamName,
    MemberRole role,
    LocalDate birthday,
    LocalDate workStartDate
) {
  public MemberResponse(Member member) {
    this(member.getName(), member.getTeamName(), member.getRole(), member.getBirthDay(), member.getCreatedAt());
  }
}
