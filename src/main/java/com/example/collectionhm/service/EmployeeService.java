package com.example.collectionhm.service;

import com.example.collectionhm.model.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {
    public Collection<Employee> getAllEmployees();

    public List<Employee> addEmployee(String firstName, String lastName);

    public List<Employee> deleteEmployee(String firstName, String lastName);

    public Employee getEmployee(String firstName, String lastName);
}
