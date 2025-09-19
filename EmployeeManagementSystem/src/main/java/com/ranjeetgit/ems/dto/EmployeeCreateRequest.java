package com.ranjeetgit.ems.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class EmployeeCreateRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Phone number is required")
    private String phone;

    @NotNull(message = "Salary is required")
    @Min(value = 0, message = "Salary must be positive")
    private Double salary;

    @NotNull(message = "Join date is required")
    private LocalDate joinDate;

    @NotBlank(message = "Status is required")
    private String status; // e.g., ACTIVE, INACTIVE

    @NotNull(message = "Department ID is required")
    private int departmentId;

    public EmployeeCreateRequest(String name, String email, String phone, Double salary, LocalDate joinDate, String status, int departmentId) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.joinDate = joinDate;
        this.status = status;
        this.departmentId = departmentId;
    }

    public @NotBlank(message = "Name is required") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name is required") String name) {
        this.name = name;
    }

    public @NotNull(message = "Department ID is required") int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(@NotNull(message = "Department ID is required") int departmentId) {
        this.departmentId = departmentId;
    }

    public @NotBlank(message = "Status is required") String getStatus() {
        return status;
    }

    public void setStatus(@NotBlank(message = "Status is required") String status) {
        this.status = status;
    }

    public @NotNull(message = "Join date is required") LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(@NotNull(message = "Join date is required") LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public @NotNull(message = "Salary is required") @Min(value = 0, message = "Salary must be positive") Double getSalary() {
        return salary;
    }

    public void setSalary(@NotNull(message = "Salary is required") @Min(value = 0, message = "Salary must be positive") Double salary) {
        this.salary = salary;
    }

    public @NotBlank(message = "Phone number is required") String getPhone() {
        return phone;
    }

    public void setPhone(@NotBlank(message = "Phone number is required") String phone) {
        this.phone = phone;
    }

    public @Email(message = "Invalid email format") @NotBlank(message = "Email is required") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Invalid email format") @NotBlank(message = "Email is required") String email) {
        this.email = email;
    }
}
