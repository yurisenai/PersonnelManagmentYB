package com.example.demo.models;

import java.io.Serializable;
import java.util.Objects;

public class EmployeeProjectId implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int employee;
    private int project;

    public EmployeeProjectId() {}

    public EmployeeProjectId(int employee, int project) {
        this.employee = employee;
        this.project = project;
    }

    // Getters, Setters, equals, and hashCode methods

    public int getEmployee() {
        return employee;
    }

    public void setEmployee(int employee) {
        this.employee = employee;
    }

    public int getProject() {
        return project;
    }

    public void setProject(int project) {
        this.project = project;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeProjectId that = (EmployeeProjectId) o;
        return employee == that.employee && project == that.project;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee, project);
    }
}
