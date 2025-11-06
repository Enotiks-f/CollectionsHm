package com.example.collectionhm;

import com.example.collectionhm.exception.EmployeeAlreadyAddedException;
import com.example.collectionhm.exception.EmployeeNotFoundException;
import com.example.collectionhm.exception.EmployeeStorageIsFullException;
import com.example.collectionhm.model.Employee;
import com.example.collectionhm.service.serviceimple.EmployeeServiceImple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

public class EmployeeServiceTest {

    private EmployeeServiceImple employeeServiceImple;

    @BeforeEach
    public void setUp() {
        employeeServiceImple = new EmployeeServiceImple();
//        Employee("Алексей", "Пупиков", 55000, 1);
//        Employee("Илья", "Титов", 800000, 2);
//        Employee("Лев", "Вальдемарович", 250000, 1);
    }

//  Тесты метода addEmployee
    //тест добавление сотрудников
    @Test
    public void testAddEmployee() {
        Collection<Employee> res = employeeServiceImple.addEmployee("Илья", "Титов", 800000, 2);
        Assertions.assertEquals(1, res.size());
    }
    //тест добавление на макс кол во сотрудников
    @Test
    public void testAddMaxEmployee() {
        employeeServiceImple.addEmployee("Илья", "Титов", 800000, 2);
        employeeServiceImple.addEmployee("Лев", "Вальдемарович", 250000, 1);
        employeeServiceImple.addEmployee("Алексей", "Пупиков", 55000, 1);
        employeeServiceImple.addEmployee("Петр", "Первый", 200000, 2);
        employeeServiceImple.addEmployee("Кира", "Старс", 100000, 3);
        employeeServiceImple.addEmployee("Кира1", "Старс1", 100000, 3);
        Assertions.assertThrows(EmployeeStorageIsFullException.class, () -> employeeServiceImple.addEmployee("Ольга", "Первая", 100000, 3));
    }

    //тест на добавление одинаковых сотрудников
    @Test
    public void testAddEmployeeAlreadyAddedException() {
        employeeServiceImple.addEmployee("Кира", "Старс", 100000, 3);
        Assertions.assertThrows(EmployeeAlreadyAddedException.class, () -> employeeServiceImple.addEmployee("Кира", "Старс", 100000, 3));
    }

//  Тесты метода removeEmployee

    //тест на удаление сотрудников
    @Test
    public void testRemoveEmployee() {
        employeeServiceImple.addEmployee("Илья", "Титов", 800000, 2);
        employeeServiceImple.addEmployee("Лев", "Вальдемарович", 250000, 1);
        Collection<Employee> res = employeeServiceImple.removeEmployee("Илья", "Титов");

        Assertions.assertEquals(1, res.size());
    }

    //тест на ошибку в поиске сотрудника для удаления
    @Test
    public void testRemoveEmployeeNotFoundException() {
        employeeServiceImple.addEmployee("Илья", "Титов", 800000, 2);
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> employeeServiceImple.removeEmployee("Илья", "Маликов"));
    }
    
    //Тест на поиск одного сотрудника
    @Test
    public void testFindAllEmployees() {
        Employee emp = new Employee("Лев", "Вальдемарович", 250000, 1);

        employeeServiceImple.addEmployee("Илья", "Титов", 800000, 2);
        employeeServiceImple.addEmployee("Лев", "Вальдемарович", 250000, 1);
        Employee res = employeeServiceImple.findEmployee("Лев", "Вальдемарович");
        Assertions.assertEquals(emp,res);
    }

    //тест на ошибку при поиске сотрудника
    @Test
    public void testFindEmployeeNotFoundException() {
        employeeServiceImple.addEmployee("Илья", "Титов", 800000, 2);
        employeeServiceImple.addEmployee("Лев", "Вальдемарович", 250000, 1);
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> employeeServiceImple.findEmployee("Лев1", "Вальдемарович1"));
    }

    @Test
    public void testFindAllEmployee() {
        employeeServiceImple.addEmployee("Илья", "Титов", 800000, 2);
        employeeServiceImple.addEmployee("Лев", "Вальдемарович", 250000, 1);
        Collection<Employee>  result = employeeServiceImple.findAllEmployees();
        Assertions.assertEquals(2, result.size());

    }

}
