package com.example.collectionhm.service;

import com.example.collectionhm.Employee;
import com.example.collectionhm.exception.EmployeeAlreadyAddedException;
import com.example.collectionhm.exception.EmployeeNotFoundException;
import com.example.collectionhm.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImple implements EmployeeService {
    private final List<Employee> employees = new ArrayList<>();
    private final Integer maxEmployees = 6;

    // метод добавления сотридника в лист
    public List<Employee> addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        // Проверка на макс. кол-во сотрудников
        if (employees.size() >= maxEmployees) {
            throw new EmployeeStorageIsFullException("Кол-во сотрудников превысило максимальное значение: " + maxEmployees);
        }

        // Проверка на дубликат
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
        }
        employees.add(employee);

        return employees;
    }

    // метод удаления соттрудника из листа
    public List<Employee> deleteEmployee(String firstName, String lastName) {
        boolean a = employees.remove(new Employee(firstName, lastName));
        if (!a) {
            throw new EmployeeNotFoundException("Сотрудник " + firstName + " " + lastName + "не найден");
        }
        return employees;
    }

    public Collection<Employee> getAllEmployees() {
        return Collections.unmodifiableList(employees);
    }

    // метод получение сотрудника по индексу
    public Employee getEmployee(String firstName, String lastName) {
        Employee employee = null;
        for (Employee i : employees) {
            if (i == null) {
                throw new EmployeeNotFoundException("Сотрудник не Найден");
            }

            if (i.getFirstName().equals(firstName) && i.getLastName().equals(lastName)) {
                employee = i;
            }
        }
        return employee;
    }

}
