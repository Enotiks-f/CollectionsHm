package com.example.collectionhm.service;

import com.example.collectionhm.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface EmployeeService {
    public Collection<Employee> addEmployee(String firstName, String lastName);

    public Collection<Employee> removeEmployee (String firstName, String lastName);

    public Employee findEmployee(String firstName, String lastName);

    public Collection<Employee> findAllEmployees();

}
