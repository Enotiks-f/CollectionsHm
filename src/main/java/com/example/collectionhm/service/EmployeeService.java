package com.example.collectionhm.service;

import com.example.collectionhm.Employee;

import java.util.List;

public interface EmployeeService {
    public int getSizeEmployees();
    public List<Employee> addEmployee(String firstName, String lastName);
    public String deleteEmployee(String firstName, String lastName);
    public Employee getEmployee(int index);
}
