package com.webknot.d2_assign2.controller;

import com.webknot.d2_assign2.dto.ProjectDto;
import com.webknot.d2_assign2.entity.Project;
import com.webknot.d2_assign2.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/projects")
public class ProjectController {
    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity<Project> addProject(@RequestBody ProjectDto projectDto) {
        return ResponseEntity.ok(projectService.addProject(projectDto));
    }
}

