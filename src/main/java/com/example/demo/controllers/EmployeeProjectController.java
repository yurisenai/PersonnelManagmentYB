package com.example.demo.controllers;

import com.example.demo.models.EmployeeProject;
import com.example.demo.services.EmployeeProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee-projects")
public class EmployeeProjectController {
    @Autowired
    private EmployeeProjectService employeeProjectService;

    @GetMapping
    public List<EmployeeProject> getAllEmployeeProjects() {
        return employeeProjectService.getAllEmployeeProjects();
    }

    @GetMapping("/{employeeId}/{projectId}")
    public ResponseEntity<EmployeeProject> getEmployeeProjectById(@PathVariable int employeeId, @PathVariable int projectId) {
        return employeeProjectService.findById(employeeId, projectId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public EmployeeProject createEmployeeProject(@RequestBody EmployeeProject employeeProject) {
        return employeeProjectService.saveEmployeeProject(employeeProject);
    }

    @PutMapping("/{employeeId}/{projectId}")
    public ResponseEntity<EmployeeProject> updateEmployeeProject(@PathVariable int employeeId, @PathVariable int projectId, @RequestBody EmployeeProject employeeProject) {
        return employeeProjectService.findById(employeeId, projectId)
                .map(existingEmployeeProject -> {
                    employeeProject.setEmployee(existingEmployeeProject.getEmployee());
                    employeeProject.setProject(existingEmployeeProject.getProject());
                    return ResponseEntity.ok(employeeProjectService.saveEmployeeProject(employeeProject));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{employeeId}/{projectId}")
    public void deleteEmployeeProject(@PathVariable int employeeId, @PathVariable int projectId) {
        employeeProjectService.deleteEmployeeProject(employeeId, projectId);
    }
}
