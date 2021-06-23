package com.xib.assessment.repo;

import com.xib.assessment.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {
    List<Team> findTeamsByAgentsIsNull();
}
