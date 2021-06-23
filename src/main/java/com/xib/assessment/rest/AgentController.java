package com.xib.assessment.rest;

import com.xib.assessment.entity.Agent;
import com.xib.assessment.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AgentController {

    @Autowired
    private AgentService agentService;

    @GetMapping(value = "/all-agents", produces = "application/json")
    public ResponseEntity getAgents() {
        return ResponseEntity.ok(agentService.getAgents());
    }

    @GetMapping(value = "/agents", produces = "application/json")
    public List<Agent> findAllAgents(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "3", required = false) int size) {
        return agentService.getAgents(page, size);
    }

    @GetMapping(value = "/agent/{id}", produces = "application/json")
    public Optional<Agent> findAgent(@PathVariable("id") Long id) throws Exception {
        return agentService.findAgent(id);
    }

    @PostMapping(value = "/agent", produces = "application/json")
    public Agent createAgent(@NonNull @RequestBody Agent agent) {
        return agentService.createAgent(agent);
    }

}
