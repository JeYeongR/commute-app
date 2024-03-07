package org.example.mini.team.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.mini.common.entity.DateTimeBaseEntity;
import org.example.mini.member.domain.Member;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team extends DateTimeBaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id = null;

  @Column(nullable = false)
  private String name;

  @OneToMany(mappedBy = "team")
  private List<Member> members = new ArrayList<>();

  @Builder
  public Team(String name) {
    this.name = name;
  }
}
