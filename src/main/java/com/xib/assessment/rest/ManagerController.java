package com.xib.assessment.rest;

import com.xib.assessment.entity.Manager;
import com.xib.assessment.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @PostMapping(value = "/manager", consumes = "application/json", produces = "application/json")
    public Manager createTeam(@NonNull @RequestBody Manager manager) {
        return managerService.createManager(manager);
    }
}
