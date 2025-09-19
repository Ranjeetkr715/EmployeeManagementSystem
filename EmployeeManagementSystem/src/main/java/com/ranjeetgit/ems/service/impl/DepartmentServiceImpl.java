package com.ranjeetgit.ems.service.impl;

import com.ranjeetgit.ems.dto.DepartmentCreateRequest;
import com.ranjeetgit.ems.dto.DepartmentDTO;
import com.ranjeetgit.ems.entities.Department;
import com.ranjeetgit.ems.mapper.DepartmentMapper;
import com.ranjeetgit.ems.repository.DepartmentRepository;
import com.ranjeetgit.ems.service.DepartmentService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DepartmentMapper departmentMapper;


    @Override
    public DepartmentDTO createDepartment(DepartmentCreateRequest departmentCreateRequest) {
        Department department = departmentMapper.mapToEntity(departmentCreateRequest);
        if (department.getEmployees() != null) {
            department.getEmployees().forEach(emp -> emp.setDepartment(department));
        }
        Department saveDepartment = departmentRepository.save(department);
        DepartmentDTO departmentDTO = departmentMapper.mapToDTO(saveDepartment);
        return departmentDTO;
    }

//    @Override
//    public List<EmployeeDTO> getAllDepartment() {
//        return departmentRepository.findAll();
//    }

    public DepartmentDTO getDepartmentById(int id){
        Department department = departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found based on the given input"));
        DepartmentDTO departmentDTO = departmentMapper.mapToDTO(department);
        return departmentDTO;
    }
}
