package org.example.mini.team.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.mini.team.dto.request.TeamCreateRequest;
import org.example.mini.team.dto.response.TeamResponse;
import org.example.mini.team.service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
@RequiredArgsConstructor
public class TeamController {

  private final TeamService teamService;

  @PostMapping()
  public void createTeam(@RequestBody @Valid TeamCreateRequest request) {
    this.teamService.createTeam(request);
  }

  @GetMapping()
  public List<TeamResponse> findAllTeams() {
    return this.teamService.findAllTeams();
  }
}
