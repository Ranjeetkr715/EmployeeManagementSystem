package com.ranjeetgit.ems.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(unique = true)
    private String email;

    private String phone;

    private Double salary;

    private LocalDate joinDate;

    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    public Employee() {}

    public Employee(int id, String name, String email, String phone, Double salary, LocalDate joinDate, EmployeeStatus status, Department department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.joinDate = joinDate;
        this.status = status;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


}
