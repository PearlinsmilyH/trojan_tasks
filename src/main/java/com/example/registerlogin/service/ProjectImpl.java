package com.example.registerlogin.service;

import com.example.registerlogin.dto.ProjectDTO;
import com.example.registerlogin.entity.ProjectEntity;
import com.example.registerlogin.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProjectImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public ResponseEntity<String> createProject(ProjectDTO projectDTO) {
        ProjectEntity projectEntity = new ProjectEntity(
                projectDTO.getId(),projectDTO.getProjectName());
        projectRepository.save(projectEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body("Project created successfully");
    }

    @Override
    public ResponseEntity<List<?>> getProjects() {
        List<ProjectEntity> projects = projectRepository.findAll();
        return ResponseEntity.ok(projects);
    }
}
