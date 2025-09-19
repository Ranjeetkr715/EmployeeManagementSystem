package com.ranjeetgit.ems.service;

import com.ranjeetgit.ems.dto.DepartmentCreateRequest;
import com.ranjeetgit.ems.dto.DepartmentDTO;
import com.ranjeetgit.ems.dto.EmployeeCreateRequest;
import com.ranjeetgit.ems.dto.EmployeeDTO;
import com.ranjeetgit.ems.entities.Department;
import com.ranjeetgit.ems.entities.Employee;

import java.util.List;

public interface DepartmentService {

    public DepartmentDTO createDepartment(DepartmentCreateRequest departmentCreateRequest);

//    public List<EmployeeDTO> getAllDepartment();

    public DepartmentDTO getDepartmentById(int id);
}
