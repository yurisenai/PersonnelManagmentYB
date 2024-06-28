package com.example.demo.services;

import com.example.demo.models.EmployeeProject;
import com.example.demo.models.EmployeeProjectId;
import com.example.demo.repositories.EmployeeProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeProjectService {
    @Autowired
    private EmployeeProjectRepository repository;

    public List<EmployeeProject> getAllEmployeeProjects() {
        return repository.findAll();
    }

    public EmployeeProject saveEmployeeProject(EmployeeProject employeeProject) {
        return repository.save(employeeProject);
    }

    public Optional<EmployeeProject> findById(int employeeId, int projectId) {
        return repository.findById(new EmployeeProjectId(employeeId, projectId));
    }

    public void deleteEmployeeProject(int employeeId, int projectId) {
        repository.deleteById(new EmployeeProjectId(employeeId, projectId));
    }
}
