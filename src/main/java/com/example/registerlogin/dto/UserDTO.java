package com.example.registerlogin.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDTO {
    private String email;
    private String password;
    public UserDTO() {
    }
    @Override
    public String toString() {
        return "EmployeeDTO{" +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

