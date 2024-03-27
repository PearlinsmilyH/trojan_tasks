package com.example.registerlogin.service;

import com.example.registerlogin.dto.ProjectDTO;
import org.springframework.http.ResponseEntity;
import java.util.List;
public interface ProjectService {
    ResponseEntity<?> createProject(ProjectDTO projectDTO);
    ResponseEntity<List<?>> getProjects();
}
