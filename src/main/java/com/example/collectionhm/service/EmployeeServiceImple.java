package com.example.collectionhm.service;

import com.example.collectionhm.exception.EmployeeAlreadyAddedException;
import com.example.collectionhm.exception.EmployeeStorageIsFullException;
import com.example.collectionhm.model.Employee;
import com.example.collectionhm.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImple implements EmployeeService {


    private final Map<String, Employee> employees = new HashMap<>();
    private final Integer maxEmployees = 6;

    // Метод добавления (возвращает список всех сотрудников)
    public Collection<Employee> addEmployee(String firstName, String lastName, int salary, String department) {
        String key = firstName + lastName;

        if (employees.size() >= maxEmployees) {
            throw new EmployeeStorageIsFullException("Хранилище переполнено");
        }

        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже существует");
        }

        employees.put(key, new Employee(firstName, lastName, salary, department));
        return findAllEmployees();
    }

    // Метод удаления (возвращает список оставшихся сотрудников)
    public Collection<Employee> removeEmployee(String firstName, String lastName) {
        String key = firstName + lastName;

        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException("Не найден сотрудник для удаления");
        }

        employees.remove(key);
        return findAllEmployees();
    }


    // Метод поиска (возвращает одного сотрудника)
    public Employee findEmployee(String firstName, String lastName) {
        String key = firstName + lastName;
        Employee employee = employees.get(key);

        if (employee == null) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }

        return employee;
    }

    // Метод получения всех сотрудников
    public Collection<Employee> findAllEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }

    // Метод получение всех Emploee депортаммента
    public List<Employee> getEmploeeDeportament(String department) {
        List<Employee> res = employees.values()
                .stream().filter(employee -> employee.getDepartment()
                        .equals(department)).collect(Collectors.
                        toList());

        if (res.isEmpty()) {
            throw new EmployeeNotFoundException("Department not found");
        }

        return res;
    }

    //Метод получение Сотрудника с мин зп
    @Override
    public Optional<Employee> getMinSalaryEmployee(String department) {
        return Optional.of(employees.values().stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("В отделе нет сотрудников"))) ;

    }

    //Метод получение Сотрудника с макс зп
    @Override
    public Optional<Employee> getMaxSalaryEmployee(String department) {
        return Optional.of(employees.values().stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("В отделе нет сотрудников"))) ;
    }


}
