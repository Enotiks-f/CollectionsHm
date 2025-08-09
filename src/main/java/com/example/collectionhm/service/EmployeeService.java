package com.example.collectionhm.service;

import com.example.collectionhm.Employee;
import com.example.collectionhm.exception.EmployeeAlreadyAddedException;
import com.example.collectionhm.exception.EmployeeNotFoundException;
import com.example.collectionhm.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>();
    private final Integer maxEmployees = 6;

    // метод получения размера листа
    public int getSizeEmployees() {
        return employees.size();
    }


    // метод добавления сотридника в лист
    public void addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        // Проверка на макс. кол-во сотрудников
        if  (employees.size() >= maxEmployees) {
            throw new EmployeeStorageIsFullException("Кол-во сотрудников превысило максимальное значение: " + maxEmployees);
        }

        // Проверка на дубликат
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
        }
        employees.add(employee);

    }

    // метод удаления соттрудника из листа
    public String deleteEmployee(String firstName, String lastName) {
        boolean a = employees.remove(new Employee(firstName, lastName));
        if (!a){
            throw new EmployeeNotFoundException("Сотрудник " +  firstName + " " + lastName + "не найден");
        }
        return "Сотрудник " +  firstName + " " + lastName + "был удален";
    }

    // метод получение сотрудника по индексу
    public Employee getEmployee(int index) {
        try {
            return employees.get(index);
        }catch (EmployeeNotFoundException e){
            throw new EmployeeNotFoundException("Cотрудник с " + index + " индексом не найден");
        }
    }

}