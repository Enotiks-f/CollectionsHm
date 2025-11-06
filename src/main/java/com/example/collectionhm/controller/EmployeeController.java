package com.example.collectionhm.controller;

import com.example.collectionhm.model.Employee;
import com.example.collectionhm.service.serviceimple.EmployeeServiceImple;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {


    private final EmployeeServiceImple employeeService;

    public EmployeeController(EmployeeServiceImple employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Collection<Employee> addEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int salary, @RequestParam int department) {
        return employeeService.addEmployee(firstName, lastName, salary, department);
    }

    @GetMapping("/remove")
    public Collection<Employee> removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping("/findAll")
    public Collection<Employee> findAllEmployees() {
        return employeeService.findAllEmployees();
    }

}

        