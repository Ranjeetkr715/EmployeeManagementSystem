package com.ranjeetgit.ems.controller;

import com.ranjeetgit.ems.dto.EmployeeCreateRequest;
import com.ranjeetgit.ems.dto.EmployeeDTO;
import com.ranjeetgit.ems.service.impl.EmployeeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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

    //offset = (pageNo-1) * pageSize  ==> 0,5,10,15

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee(@RequestParam(required = false,defaultValue = "1") int pageNo,
                                                            @RequestParam(required = false,defaultValue = "3") int pageSize,
                                                            @RequestParam(required = false,defaultValue = "id") String sortBy ,
                                                            @RequestParam(defaultValue = "asc") String sortDir,
                                                            @RequestParam String search
                                                            ){
        Sort sort= sortDir.equalsIgnoreCase("ASC") ? Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        PageRequest pageRequest = PageRequest.of(pageNo-1, pageSize,sort);
        return ResponseEntity.ok(employeeService.getAllEmployee(pageRequest,search));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable int id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }
}
