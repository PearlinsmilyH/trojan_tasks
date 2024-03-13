package com.example.RegisterLogin.service;

import com.example.RegisterLogin.dto.EmployeeDTO;
import com.example.RegisterLogin.dto.LoginDTO;
import com.example.RegisterLogin.entity.Employee;
import com.example.RegisterLogin.repository.EmployeeRepository;
import com.example.RegisterLogin.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class EmployeeImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepo;


    @Override
    public int addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(

                employeeDTO.getEmployeeid(),
                employeeDTO.getEmail()
        );

        employeeRepo.save(employee);

        return employee.getEmployeeid();

    }

    @Override
    public LoginResponse loginEmployee(LoginDTO loginDTO) {
        String msg = "";
        Employee employee1 = employeeRepo.findByEmail(loginDTO.getEmail());
        if (employee1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = employee1.getPassword();
            if (password.equals(encodedPassword)){
                Optional<Employee> employee = employeeRepo.findOneByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword());
                if (employee.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("Password Not Match", false);
            }
        } else {
            return new LoginResponse("Email Not Exits", false);
        }

    }
}