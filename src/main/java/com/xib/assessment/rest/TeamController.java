package com.xib.assessment.rest;

import com.xib.assessment.entity.Agent;
import com.xib.assessment.entity.Team;
import com.xib.assessment.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping(value = "/team/{id}", produces = "application/json")
    public Optional<Team> findTeam(@PathVariable("id") Long id) throws Exception {
        return teamService.findTeam(id);
    }

    @GetMapping(value = "/teams", produces = "application/json")
    public List<Team> getTeams() {
        return teamService.getTeams();
    }

    @PostMapping(value = "/team", produces = "application/json")
    public Team createTeam(@NonNull @RequestBody Team team) {
        return teamService.createTeam(team);
    }

    @PutMapping(value = "/team/{id}/agent", produces = "application/json")
    public Team addAgentToTeam(@PathVariable("id") Long id, @NonNull @RequestBody Agent agent) throws Exception {
        return teamService.assignAgentToTeam(id, agent);
    }

    @GetMapping(value = "/empty-teams", produces = "application/json")
    public List<Team> getEmptyTeams() {
        return teamService.getEmptyTeams();
    }
}
