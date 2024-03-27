package com.example.registerlogin.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String projectName;

    public ProjectEntity(Long id, String projectName) {
        this.id = id;
        this.projectName = projectName;
    }

    public ProjectEntity() {
    }
}