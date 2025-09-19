package com.ranjeetgit.ems.dto;

import java.time.LocalDate;

public class EmployeeDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private Double salary;
    private LocalDate joinDate;
    private String status;
    private Long departmentId;
//    private String departmentName;

    public EmployeeDTO(){}

    public EmployeeDTO(Long id, String name, String email, String phone, Double salary, LocalDate joinDate, String status, Long departmentId, String departmentName) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.joinDate = joinDate;
        this.status = status;
        this.departmentId = departmentId;
//        this.departmentName = departmentName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", joinDate=" + joinDate +
                ", status='" + status + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }
}
