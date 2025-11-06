package com.example.collectionhm.service.serviceimple;

import com.example.collectionhm.exception.EmployeeNotFoundException;
import com.example.collectionhm.model.Employee;
import com.example.collectionhm.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImple implements DepartmentService {

    private final EmployeeServiceImple employeeServiceImple;

    public DepartmentServiceImple(EmployeeServiceImple employeeServiceImple) {
        this.employeeServiceImple = employeeServiceImple;
    }

    @Override
    public List<Employee> getDepartaments(int departmentId) {
        List<Employee> res = employeeServiceImple.findAllEmployees()
                .stream().filter(employee -> employee.getDepartment() == departmentId)
                .collect(Collectors.toList());
        return res;
    }

    @Override
    public int getSumSalaryDepartament(int departmentId) {
        return getDepartaments(departmentId).stream().mapToInt(Employee::getSalary).sum();
    }

    @Override
    public Optional<Employee> getMaxSalaryDepartament(int departmentId) {
        return Optional.of(employeeServiceImple.findAllEmployees().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("В отделе нет сотрудников")));
    }

    @Override
    public Optional<Employee> getMinSalaryDepartament(int departmentId) {
        return Optional.of(employeeServiceImple.findAllEmployees().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("в отделе нет сотрудников")));
    }


    @Override
    public Map<Integer, List<Employee>> getAllDepartaments() {
        return employeeServiceImple.findAllEmployees().stream().collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
