package com.xib.assessment.repo;

import com.xib.assessment.entity.Manager;
import com.xib.assessment.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManagerRepository  extends JpaRepository<Manager, Long> {
    //public List<Team> findManagerBy
}
