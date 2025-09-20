package com.ranjeetgit.ems.service.impl;

import com.ranjeetgit.ems.dto.EmployeeCreateRequest;
import com.ranjeetgit.ems.dto.EmployeeDTO;
import com.ranjeetgit.ems.entities.Department;
import com.ranjeetgit.ems.entities.Employee;
import com.ranjeetgit.ems.exception.EmployeeNotFoundException;
import com.ranjeetgit.ems.mapper.EmployeeMapper;
import com.ranjeetgit.ems.repository.DepartmentRepository;
import com.ranjeetgit.ems.repository.EmployeeRepository;
import com.ranjeetgit.ems.service.EmployeeService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    @CacheEvict(value = {"employees", "employee"}, allEntries = true)
    public EmployeeDTO createEmployee(EmployeeCreateRequest employeeCreateRequest) {
        Employee employee = employeeMapper.mapEmployeeRequestToEntity(employeeCreateRequest);
        Optional<Department> department = departmentRepository.findById(employee.getDepartment().getId());
        if(department.isPresent()) {
            employee.setDepartment(department.get());
        }
        employeeRepository.save(employee);
        EmployeeDTO employeeDTO = employeeMapper.mapToDTO(employee);
        System.out.println("employeeDTO details : " + employeeDTO.toString());
        return employeeDTO;
    }

    @Override
    @Cacheable(value = "employees",key = "#pageRequest.pageNumber + '-' + #pageRequest.pageSize + '-' + #search")
    public List<EmployeeDTO> getAllEmployee(PageRequest pageRequest,String search) {
        Page<Employee> employees;
        if(search==null){
            employees = employeeRepository.findAll(pageRequest);
        }else {
            employees = employeeRepository.findByNameContainingIgnoreCase(pageRequest,search);
        }
        return employees.stream().map(a -> employeeMapper.mapToDTO(a)).toList();
    }

    @Cacheable(value = "employee",key = "#id")
    public EmployeeDTO getEmployeeById(int id){
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found based on the given input id :- " + id));
        EmployeeDTO employeeDTO = employeeMapper.mapToDTO(employee);
        return employeeDTO;
    }



}
