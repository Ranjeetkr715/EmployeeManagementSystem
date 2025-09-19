package com.ranjeetgit.ems.mapper;

import com.ranjeetgit.ems.dto.DepartmentCreateRequest;
import com.ranjeetgit.ems.dto.DepartmentDTO;
import com.ranjeetgit.ems.dto.EmployeeCreateRequest;
import com.ranjeetgit.ems.dto.EmployeeDTO;
import com.ranjeetgit.ems.entities.Department;
import com.ranjeetgit.ems.entities.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "departmentId", target = "department.id")
    Employee mapEmployeeRequestToEntity(EmployeeCreateRequest employeeCreateRequest);

    @Mapping(source = "department.id",target = "departmentId")
    EmployeeDTO mapToDTO(Employee employee);

}
