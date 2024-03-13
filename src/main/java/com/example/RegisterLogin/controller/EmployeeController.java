package com.example.RegisterLogin.controller;

import com.example.RegisterLogin.dto.EmployeeDTO;
import com.example.RegisterLogin.dto.LoginDTO;
import com.example.RegisterLogin.response.LoginResponse;
import com.example.RegisterLogin.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class EmployeeController {
@Autowired
public EmployeeService employeeService;
    @PostMapping(path = "/register")
    public String saveEmployee(@RequestBody EmployeeDTO employeeDTO)
    {
        String id = String.valueOf(employeeService.addEmployee(employeeDTO));
        return id;
    }
    @PostMapping(path = "/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO)
    {
        LoginResponse loginResponse = employeeService.loginEmployee(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
}
