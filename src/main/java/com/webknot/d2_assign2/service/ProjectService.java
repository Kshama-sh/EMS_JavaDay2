package com.webknot.d2_assign2.service;

import com.webknot.d2_assign2.dto.ProjectDto;
import com.webknot.d2_assign2.entity.Project;
import com.webknot.d2_assign2.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project addProject(ProjectDto projectDto) {
        Project project = new Project();
        project.setProjectName(projectDto.getProjectName());
        project.setDescription(projectDto.getDescription());
        return projectRepository.save(project);
    }
}
