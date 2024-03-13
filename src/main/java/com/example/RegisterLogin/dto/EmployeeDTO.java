package com.example.RegisterLogin.dto;

public class EmployeeDTO {
    private int employeeId;
    private String email;
    private String password;

    public EmployeeDTO(int employeeId, String email, String password) {
        this.employeeId = employeeId;
        this.email = email;
        this.password = password;
    }

    public EmployeeDTO() {
    }

    public int getEmployeeid() {
        return employeeId;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeId = employeeid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "employeeid=" + employeeId +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
