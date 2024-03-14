package com.example.registerlogin.entity;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @Column(name="id", length = 45)
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int employeeId;
    @Column(name="email", length = 255)
    private String email;
    @Column(name="password", length = 255)
    private String password;

    public User(int employeeId, String email, String password) {
        this.employeeId = employeeId;
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    public User(int employeeId, String email) {
        this.employeeId = employeeId;
        this.email = email;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
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
        return "Employee{" +
                "employeeid=" + employeeId +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
