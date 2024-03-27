package com.example.registerlogin.service;

import com.example.registerlogin.dto.ResetPasswordDTO;
import com.example.registerlogin.dto.UserDTO;
import org.springframework.http.ResponseEntity;


public interface UserService {
    int addUser(UserDTO userDTO);

    ResponseEntity<?> login(UserDTO userDTO);

    ResponseEntity<?> forgotPassword(ResetPasswordDTO resetPasswordDTO);
}
