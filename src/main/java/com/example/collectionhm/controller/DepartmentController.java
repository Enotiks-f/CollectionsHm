package com.example.collectionhm.controller;

import com.example.collectionhm.model.Employee;
import com.example.collectionhm.service.serviceimple.DepartmentServiceImple;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/department")
public class DepartmentController {


    private final DepartmentServiceImple departamentServiceImple;

    public DepartmentController(DepartmentServiceImple departamentServiceImple) {
        this.departamentServiceImple = departamentServiceImple;
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getDepartament(@PathVariable int id) {
        return departamentServiceImple.getDepartaments(id);
    }

    @GetMapping("/{id}/salary/sum")
    public int getSumSalaryDepartaments(@PathVariable int id) {
        return departamentServiceImple.getSumSalaryDepartament(id);
    }

    @GetMapping("/{id}/salary/max")
    public Optional<Employee> getMaxSalaryDepartament(@PathVariable int id) {
        return departamentServiceImple.getMaxSalaryDepartament(id);
    }

    @GetMapping("/{id}/salary/min")
    public Optional<Employee> getMinSalaryDepartament(@PathVariable int id) {
        return departamentServiceImple.getMinSalaryDepartament(id);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getEmployeesbyDeportament() {
        return departamentServiceImple.getAllDepartaments();
    }


}
