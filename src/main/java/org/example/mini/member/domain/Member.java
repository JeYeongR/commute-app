package org.example.mini.member.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.mini.common.entity.DateTimeBaseEntity;
import org.example.mini.team.domain.Team;

import java.time.LocalDate;

@Entity
@Getter
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

  @ManyToOne
  private Team team;

  @Builder
  public Member(String name, boolean isManager, LocalDate birthDay) {
    this.name = name;
    this.role = this.grantRole(isManager);
    this.birthDay = birthDay;
  }

  public String getTeamName() {
    return this.team.getName();
  }

  public void joinTeam(Team team) {
    this.team = team;
    team.getMembers().add(this);
  }

  private MemberRole grantRole(boolean isManager) {
    return isManager ? MemberRole.MANAGER : MemberRole.MEMBER;
  }
}
