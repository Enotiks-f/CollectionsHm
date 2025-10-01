package com.example.collectionhm.controller;

import com.example.collectionhm.model.Employee;
import com.example.collectionhm.service.EmployeeServiceImple;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {


    private final EmployeeServiceImple employeeService;

    public EmployeeController(EmployeeServiceImple employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Collection<Employee> addEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int salary, @RequestParam String department) {
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

    @GetMapping("/departments/all")
    public List<Employee> findAllDepartments(@RequestParam String department) {
        return employeeService.getEmploeeDeportament(department);
    }

    @GetMapping("/departments/max-salary")
    public Optional<Employee> EmpDepartmentsMaxSalary(@RequestParam String department) {
        return employeeService.getMaxSalaryEmployee(department);
    }

    @GetMapping("/departments/min-salary")
    public Optional<Employee> EmpDepartmentsMinSalary(@RequestParam String department) {
        return employeeService.getMinSalaryEmployee(department);
    }
}

