package com.example.registerlogin.repository;


import com.example.registerlogin.entity.EquipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface EquipmentRepository extends JpaRepository<EquipmentEntity, String> {
    List<EquipmentEntity> findAll();
}
