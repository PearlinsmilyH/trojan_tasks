package com.example.RegisterLogin.service;

import com.example.RegisterLogin.dto.EmployeeDTO;
import com.example.RegisterLogin.dto.LoginDTO;
import com.example.RegisterLogin.response.LoginResponse;


public interface EmployeeService {
    int addEmployee(EmployeeDTO employeeDTO);

    LoginResponse loginEmployee(LoginDTO loginDTO);
}
