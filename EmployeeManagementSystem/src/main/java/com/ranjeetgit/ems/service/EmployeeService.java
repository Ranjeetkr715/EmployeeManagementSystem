package com.ranjeetgit.ems.service;

import com.ranjeetgit.ems.dto.EmployeeCreateRequest;
import com.ranjeetgit.ems.dto.EmployeeDTO;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface EmployeeService {

    public EmployeeDTO createEmployee(EmployeeCreateRequest employeeCreateRequest);

    public List<EmployeeDTO> getAllEmployee(PageRequest pageRequest,String search);

    public EmployeeDTO getEmployeeById(int id);
}
