package com.example.RegisterLogin.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    @Column(name="employee_id", length = 45)
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int employeeid;
    @Column(name="email", length = 255)
    private String email;
    @Column(name="Password", length = 255)
    private String password;

    public Employee(int employeeid, String email, String password) {
        this.employeeid = employeeid;
        this.email = email;
        this.password = password;
    }

    public Employee() {
    }

    public Employee(int employeeId, String email) {
        this.employeeid = employeeId;
        this.email = email;
    }


    public int getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
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
        return "Employee{" +
                "employeeid=" + employeeid +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
