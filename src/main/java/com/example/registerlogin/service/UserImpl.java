package com.example.registerlogin.service;

import com.example.registerlogin.config.JwtUtil;
import com.example.registerlogin.dto.ResetPasswordDTO;
import com.example.registerlogin.dto.UserDTO;
import com.example.registerlogin.entity.User;
import com.example.registerlogin.repository.UserRepository;
import com.example.registerlogin.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements UserService {
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtil jwtUtil;

    public UserImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public int addUser(UserDTO loginDTO) {
        String encodedPassword = passwordEncoder.encode(loginDTO.getPassword());

        User employee = new User(
                loginDTO.getEmail(),
                encodedPassword
        );

        userRepository.save(employee);

        return employee.getEmployeeid();
    }
    @Override
    public ResponseEntity<?>forgotPassword(ResetPasswordDTO resetPasswordDTO){
        if (resetPasswordDTO == null || resetPasswordDTO.getEmail() == null || resetPasswordDTO.getNewPassword() == null || resetPasswordDTO.getConfirmPassword() == null) {
            return ResponseEntity.badRequest().body("Email, new password, and confirm password are required.");
        }

        String email = resetPasswordDTO.getEmail();
        String newPassword = resetPasswordDTO.getNewPassword();
        String confirmPassword = resetPasswordDTO.getConfirmPassword();

        if (!newPassword.equals(confirmPassword)) {
            return ResponseEntity.badRequest().body("New password and confirm password do not match.");
        }
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return ResponseEntity.badRequest().body("User with the provided email does not exist.");
        }
        user.setPassword(passwordEncoder.encode(newPassword));

        userRepository.save(user);

        return ResponseEntity.ok("Password reset successfully.");
    }

    @Override
    public ResponseEntity<?> login(UserDTO userDTO) {
        User userDetails = userRepository.findByEmail(userDTO.getEmail());

        if (userDetails == null) {
            addUser(userDTO);
            return ResponseEntity.ok("User registered successfully");
        } else {
            if (!passwordEncoder.matches(userDTO.getPassword(), userDetails.getPassword())) {
                LoginResponse loginResponse = new LoginResponse("Invalid password", false);
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(loginResponse);
            }
        }
        String token = jwtUtil.generateTokenFromUsername(userDetails.getEmail());
        System.out.println(token);
        LoginResponse loginResponse = new LoginResponse(token, true);
        return ResponseEntity.ok(loginResponse);
    }
}
