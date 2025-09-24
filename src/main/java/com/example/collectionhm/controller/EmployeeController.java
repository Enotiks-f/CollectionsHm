package com.example.collectionhm.controller;

import com.example.collectionhm.model.Employee;
import com.example.collectionhm.service.EmployeeServiceImple;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeServiceImple employeeService;

    public EmployeeController(EmployeeServiceImple employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public List<Employee> addEmployees(@RequestParam String firstName, @RequestParam String lastName) {
        Employee employee = new Employee(firstName, lastName);
        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping
    public Collection<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping(path = "/remove")
    public List<Employee> removeEmployees(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.deleteEmployee(firstName, lastName);
    }

    @GetMapping(path = "/find")
    public Employee findEmployees(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.getEmployee(firstName, lastName);
    }
}


