package org.example.mini.member.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.mini.common.entity.DateTimeBaseEntity;
import org.example.mini.team.domain.Team;

import java.time.LocalDate;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AttributeOverride(name = "createdAt", column = @Column(name = "work_start_date"))
public class Member extends DateTimeBaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id = null;

  @Column(nullable = false)
  private String name;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private MemberRole role;

  @Column(nullable = false)
  private LocalDate birthDay;

  @ManyToOne(fetch = FetchType.LAZY)
  private Team team;

  public Member(String name, MemberRole role, LocalDate birthDay) {
    this.name = name;
    this.role = role;
    this.birthDay = birthDay;
  }
}
