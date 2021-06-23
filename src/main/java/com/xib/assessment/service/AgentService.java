package com.xib.assessment.service;

import com.xib.assessment.entity.Agent;
import com.xib.assessment.repo.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgentService {
    @Autowired
    private AgentRepository agentRepository;

    /**
     * Returns a list of all agents
     * @return List<Agent>
     */
    public List<Agent> getAgents() {
        return agentRepository.findAll();
    }

    /**
     * Returns a pageable list of agents according to supplied params
     * @param page
     * @param size
     * @return Page<Agent>
     */
    public List<Agent> getAgents(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return agentRepository.findAll(pageable).getContent();
    }

    /**
     * Returns an agent using supplied id
     * @param id
     * @return Agent
     * @throws Exception
     */
    public Optional<Agent> findAgent(Long id) throws Exception {
        return Optional.of(agentRepository.findById(id).orElseThrow(() -> new Exception("No agent found.")));
    }

    /**
     * Creates a new agent with the specified details
     * @param agent
     * @return Agent
     */
    public Agent createAgent(Agent agent) {
        return agentRepository.save(agent);
    }
}
