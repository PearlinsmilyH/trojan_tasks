package com.example.registerlogin.repository;


import com.example.registerlogin.entity.RequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface RequestRepository extends JpaRepository<RequestEntity, Long> {
}