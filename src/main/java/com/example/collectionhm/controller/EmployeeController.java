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

    @GetMapping("/add")
    public Collection<Employee> addEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.addEmployee(firstName, lastName);
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


