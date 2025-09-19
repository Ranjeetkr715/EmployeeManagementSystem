package com.ranjeetgit.ems.mapper;

import com.ranjeetgit.ems.dto.DepartmentCreateRequest;
import com.ranjeetgit.ems.dto.DepartmentDTO;
import com.ranjeetgit.ems.entities.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {EmployeeMapper.class})
public interface DepartmentMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "employees", source = "employees")
    Department mapToEntity(DepartmentCreateRequest departmentCreateRequest);

    DepartmentDTO mapToDTO(Department department);
}
