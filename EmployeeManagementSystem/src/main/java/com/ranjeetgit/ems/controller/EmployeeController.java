package com.ranjeetgit.ems.controller;

import com.ranjeetgit.ems.dto.EmployeeCreateRequest;
import com.ranjeetgit.ems.dto.EmployeeDTO;
import com.ranjeetgit.ems.service.impl.EmployeeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/ems/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @PostMapping("/create")
    public ResponseEntity<EmployeeDTO> createEmployee(
            @Valid @RequestBody EmployeeCreateRequest request) {
        EmployeeDTO created = employeeService.createEmployee(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // ✅ 1. Get employees with pagination + sorting + filtering
//    @GetMapping
//    public ResponseEntity<EmployeeDTO> getEmployees(
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int size,
//            @RequestParam(defaultValue = "id") String sortBy,
//            @RequestParam(defaultValue = "asc") String sortDir,
//            @RequestParam(required = false) Long departmentId,
//            @RequestParam(required = false) String status,
//            @RequestParam(required = false) Double minSalary,
//            @RequestParam(required = false) Double maxSalary,
//            @RequestParam(required = false) String keyword
//    ) {
//        Page<EmployeeDTO> result = employeeService.searchEmployees(
//                page, size, sortBy, sortDir,
//                departmentId, status, minSalary, maxSalary, keyword
//        );
//        return ResponseEntity.ok(result);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable int id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }
}
