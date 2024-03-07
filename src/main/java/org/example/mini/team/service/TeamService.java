package org.example.mini.team.service;

import lombok.RequiredArgsConstructor;
import org.example.mini.team.domain.TeamRepository;
import org.example.mini.team.dto.request.TeamCreateRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TeamService {

  private final TeamRepository teamRepository;

  @Transactional
  public void createTeam(TeamCreateRequest request) {
    this.teamRepository.save(request.toEntity());
  }
}
