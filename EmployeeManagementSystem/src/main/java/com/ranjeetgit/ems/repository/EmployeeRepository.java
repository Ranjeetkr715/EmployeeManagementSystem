package com.ranjeetgit.ems.repository;

import com.ranjeetgit.ems.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

   Page<Employee> findByNameContainingIgnoreCase(PageRequest pageRequest, String search);
}
