package com.ranjeetgit.ems.dto;

import com.ranjeetgit.ems.entities.Employee;

import java.util.List;

public record DepartmentDTO(int id,
                             String name,
                             String location,
                             List<EmployeeDTO>employees
                             ) { }
