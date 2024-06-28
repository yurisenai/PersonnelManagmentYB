package com.example.demo.repositories;

import com.example.demo.models.EmployeeProject;
import com.example.demo.models.EmployeeProjectId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeProjectRepository extends JpaRepository<EmployeeProject, EmployeeProjectId> {
}
