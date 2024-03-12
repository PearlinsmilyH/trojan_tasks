package com.example.RegisterLogin.Service;

import com.example.RegisterLogin.DTO.EmployeeDTO;
import com.example.RegisterLogin.DTO.LoginDTO;
import com.example.RegisterLogin.response.LoginResponse;
import org.springframework.stereotype.Service;



public interface EmployeeService {
    int addEmployee(EmployeeDTO employeeDTO);

    LoginResponse loginEmployee(LoginDTO loginDTO);
}
