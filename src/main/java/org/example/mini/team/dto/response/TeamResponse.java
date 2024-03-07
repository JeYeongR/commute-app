package org.example.mini.team.dto.response;

import org.example.mini.team.domain.Team;

public record TeamResponse(
    String name,
    String manager,
    int memberCount
) {
  public TeamResponse(Team team) {
    this(team.getName(), team.getManagerName(), team.getMemberCount());
  }
}
