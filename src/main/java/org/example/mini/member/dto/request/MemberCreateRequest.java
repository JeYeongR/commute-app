package org.example.mini.member.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.example.mini.member.domain.Member;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record MemberCreateRequest(
    @NotEmpty
    String name,

    @NotEmpty
    String teamName,

    boolean isManager,

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate birthday
) {
  public Member toEntity() {
    return Member.builder()
        .name(name)
        .isManager(isManager)
        .birthDay(birthday)
        .build();
  }
}
