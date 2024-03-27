package com.example.registerlogin.controller;
import com.example.registerlogin.config.JwtUtil;
import com.example.registerlogin.dto.ResetPasswordDTO;
import com.example.registerlogin.dto.UserDTO;
import com.example.registerlogin.entity.User;
import com.example.registerlogin.repository.UserRepository;
import com.example.registerlogin.response.LoginResponse;
import com.example.registerlogin.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginOrRegister(@RequestBody UserDTO userDTO) {
    return   userService.login(userDTO);
    }
    @PutMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestBody ResetPasswordDTO resetPasswordDTO) {
        return userService.forgotPassword(resetPasswordDTO);

    }
}

