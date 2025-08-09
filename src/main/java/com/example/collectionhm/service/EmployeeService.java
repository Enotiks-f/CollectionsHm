package com.example.collectionhm.service;

import com.example.collectionhm.Employee;

public interface EmployeeService {
    public int getSizeEmployees();
    public void addEmployee(String firstName, String lastName);
    public String deleteEmployee(String firstName, String lastName);
    public Employee getEmployee(int index);
}
