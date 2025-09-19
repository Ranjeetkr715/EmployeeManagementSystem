package com.ranjeetgit.ems.repository;

import com.ranjeetgit.ems.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
}
