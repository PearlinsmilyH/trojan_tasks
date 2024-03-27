package com.example.registerlogin.controller;
import com.example.registerlogin.dto.ProjectDTO;
import com.example.registerlogin.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @PostMapping(path = "/create")
    public ResponseEntity<?> createProject(@RequestBody ProjectDTO projectDTO) {
        return projectService.createProject(projectDTO);
    }
    @GetMapping
    public ResponseEntity<List<?>> getProject(){
        return projectService.getProjects();
    }
}

