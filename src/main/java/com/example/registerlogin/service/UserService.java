package com.example.registerlogin.service;

import com.example.registerlogin.dto.ResetPasswordDTO;
import com.example.registerlogin.dto.UserDTO;
import com.example.registerlogin.entity.User;
import com.example.registerlogin.response.LoginResponse;
import org.springframework.http.ResponseEntity;


public interface UserService {
    int addUser(UserDTO userDTO);

    ResponseEntity<?> login(UserDTO userDTO);

    ResponseEntity<?> forgotpassword(ResetPasswordDTO resetPasswordDTO);
}
