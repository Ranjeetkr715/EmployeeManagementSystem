package com.ranjeetgit.ems.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;


public class DepartmentCreateRequest {

    @NotBlank(message = "name should be not blank")
    private String name;
    private String location;
    private List<EmployeeCreateRequest> employees;

    public DepartmentCreateRequest(){}

    public DepartmentCreateRequest(String name, String location, List<EmployeeCreateRequest> employees) {
        this.name = name;
        this.location = location;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<EmployeeCreateRequest> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeCreateRequest> employees) {
        this.employees = employees;
    }
}
