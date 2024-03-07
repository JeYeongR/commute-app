package org.example.mini.team.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.mini.team.dto.request.TeamCreateRequest;
import org.example.mini.team.service.TeamService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teams")
@RequiredArgsConstructor
public class TeamController {

  private final TeamService teamService;

  @PostMapping()
  public void createTeam(@RequestBody @Valid TeamCreateRequest request) {
    this.teamService.createTeam(request);
  }
}
