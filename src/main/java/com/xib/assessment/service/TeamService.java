package com.xib.assessment.service;

import com.xib.assessment.entity.Agent;
import com.xib.assessment.entity.Team;
import com.xib.assessment.repo.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private AgentService agentService;

    /**
     * Returns a list of all teams
     * @return List<Team>
     */
    public List<Team> getTeams() {
        return teamRepository.findAll();
    }

    /**
     * Returns a pageable list of teams according to supplied params
     * @param page
     * @param size
     * @return Page<Team>
     */
    public Page<Team> getTeams(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return teamRepository.findAll(pageable);
    }

    /**
     * Returns an team using supplied id
     * @param id
     * @return Team
     * @throws Exception
     */
    public Optional<Team> findTeam(Long id) throws Exception {
        return Optional.of(teamRepository.findById(id).orElseThrow(() -> new Exception("No team found.")));
    }

    /**
     * Creates a new team with the specified details
     * @param team
     * @return Team
     */
    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    /**
     *
     * Assigns an agent to the specified team
     * @param teamId
     * @param agent
     * @return Team
     * @throws Exception
     */
    public Team assignAgentToTeam(Long teamId, Agent agent) throws Exception {
        Optional<Team> team = this.findTeam(teamId);

        if(team.isPresent()){
            Optional<Agent> dbAgent = Optional.empty();
            /* To allow for agent reassignment */
            if(agent.getId() != null && agent.getId() != 0L){
                dbAgent = agentService.findAgent(agent.getId());
                dbAgent.ifPresent(value -> value.setTeam(team.get()));
            } else {
                /* To allow for new agent assignment */
                agent.setTeam(team.get());
            }
            agentService.createAgent(dbAgent.orElse(agent));
            return team.get();
        }
        return null;
    }

    public List<Team> getEmptyTeams(){
        return teamRepository.findTeamsByAgentsIsNull();
    }
}
