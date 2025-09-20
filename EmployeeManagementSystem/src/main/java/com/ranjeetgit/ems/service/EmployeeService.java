package com.ranjeetgit.ems.service;

import com.ranjeetgit.ems.dto.EmployeeCreateRequest;
import com.ranjeetgit.ems.dto.EmployeeDTO;
import com.ranjeetgit.ems.entities.Employee;

import java.util.List;

public interface EmployeeService {

    public EmployeeDTO createEmployee(EmployeeCreateRequest employeeCreateRequest);

    public List<EmployeeDTO> getAllEmployee();

    public EmployeeDTO getEmployeeById(int id);
}
