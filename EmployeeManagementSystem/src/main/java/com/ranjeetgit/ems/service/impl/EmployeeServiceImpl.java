package com.ranjeetgit.ems.service.impl;

import com.ranjeetgit.ems.dto.EmployeeCreateRequest;
import com.ranjeetgit.ems.dto.EmployeeDTO;
import com.ranjeetgit.ems.entities.Department;
import com.ranjeetgit.ems.entities.Employee;
import com.ranjeetgit.ems.mapper.EmployeeMapper;
import com.ranjeetgit.ems.repository.DepartmentRepository;
import com.ranjeetgit.ems.repository.EmployeeRepository;
import com.ranjeetgit.ems.service.EmployeeService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;


    private EmployeeMapper employeeMapper= Mappers.getMapper(EmployeeMapper.class);

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeCreateRequest employeeCreateRequest) {
        Employee employee = employeeMapper.mapEmployeeRequestToEntity(employeeCreateRequest);
        System.out.println("Employee details : " + employee.toString());
        System.out.println("Employee details id : " + employee.getDepartment().getId());
        Optional<Department> department = departmentRepository.findById(employee.getDepartment().getId());
        if(department.isPresent()) {
            employee.setDepartment(department.get());
        }
        System.out.println("Department details : " + department.toString());
        employeeRepository.save(employee);
        EmployeeDTO employeeDTO = employeeMapper.mapToDTO(employee);
        System.out.println("employeeDTO details : " + employeeDTO.toString());
        return employeeDTO;
    }

//    @Override
//    public List<EmployeeDTO> getAllEmployee() {
//        return employeeRepository.findAll();
//    }


    public EmployeeDTO getEmployeeById(int id){
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found based on the given input"));
        EmployeeDTO employeeDTO = employeeMapper.mapToDTO(employee);
        return employeeDTO;
    }


}
