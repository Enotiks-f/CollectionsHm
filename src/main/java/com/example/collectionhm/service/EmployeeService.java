package com.example.collectionhm.service;

import com.example.collectionhm.Employee;
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
        employees.add(employee);
    }

    // метод удаления соттрудника из листа
    public String deleteEmployee(String firstName, String lastName) {
        boolean a = employees.remove(new Employee(firstName, lastName));
        if (!a){
            return "Сотрудник " +  firstName + " " + lastName + "не найден";
        }
        return "Сотрудник " +  firstName + " " + lastName + "был удален";
    }

    public Employee getEmployee(int index) {
        return employees.get(index);
    }

}