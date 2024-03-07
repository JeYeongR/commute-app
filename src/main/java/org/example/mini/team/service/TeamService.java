package org.example.mini.team.service;

import lombok.RequiredArgsConstructor;
import org.example.mini.team.domain.TeamRepository;
import org.example.mini.team.dto.request.TeamCreateRequest;
import org.example.mini.team.dto.response.TeamResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {

  private final TeamRepository teamRepository;

  @Transactional
  public void createTeam(TeamCreateRequest request) {
    this.teamRepository.save(request.toEntity());
  }

  @Transactional(readOnly = true)
  public List<TeamResponse> findAllTeams() {
    return this.teamRepository
        .findAll()
        .stream()
        .map(TeamResponse::new)
        .toList();
  }
}
