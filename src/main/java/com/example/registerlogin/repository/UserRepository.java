package com.example.registerlogin.repository;

import com.example.registerlogin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);
    Optional<User> findOneByEmailAndPassword(String email, String password);

}
