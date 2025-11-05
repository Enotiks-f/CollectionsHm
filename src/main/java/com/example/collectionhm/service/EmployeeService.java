package com.example.collectionhm.service;

import com.example.collectionhm.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface EmployeeService {
    public Collection<Employee> addEmployee(String firstName, String lastName, int salary, int department);

    public Collection<Employee> removeEmployee (String firstName, String lastName);

    public Employee findEmployee(String firstName, String lastName);

    public Collection<Employee> findAllEmployees();

    public List<Employee> getEmploeeDeportament(int department);

    public Optional<Employee> getMinSalaryEmployee(int department);

    public Optional<Employee> getMaxSalaryEmployee(int department);

    public Map<Integer, List<Employee>> getAllEmployeesGroupedByDepartment();
}
