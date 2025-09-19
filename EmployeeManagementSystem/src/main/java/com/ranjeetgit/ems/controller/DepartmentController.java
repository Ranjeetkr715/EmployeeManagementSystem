package com.ranjeetgit.ems.controller;

import com.ranjeetgit.ems.dto.DepartmentCreateRequest;
import com.ranjeetgit.ems.dto.DepartmentDTO;
import com.ranjeetgit.ems.service.impl.DepartmentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/ems/department")
public class DepartmentController {

    private DepartmentServiceImpl departmentService;

    public DepartmentController(DepartmentServiceImpl departmentService){
        this.departmentService=departmentService;
    }

    @PostMapping("/create")
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody DepartmentCreateRequest departmentCreateRequest){
        DepartmentDTO department = departmentService.createDepartment(departmentCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(department);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDTO> getEmployee(@PathVariable int id) {
        return ResponseEntity.ok(departmentService.getDepartmentById(id));
    }


}
