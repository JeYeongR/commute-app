package org.example.mini.team.dto.request;

import jakarta.validation.constraints.NotEmpty;
import org.example.mini.team.domain.Team;

public record TeamCreateRequest(
    @NotEmpty
    String name
) {
  public Team toEntity() {
    return Team.builder()
        .name(name)
        .build();
  }
}
