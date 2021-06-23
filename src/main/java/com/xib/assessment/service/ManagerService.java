package com.xib.assessment.service;

import com.xib.assessment.entity.Manager;
import com.xib.assessment.repo.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    /**
     * Creates a new manager with the specified details
     * @param manager
     * @return
     */
    public Manager createManager(Manager manager){
        return managerRepository.save(manager);
    }
}
