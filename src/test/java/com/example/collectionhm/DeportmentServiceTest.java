package com.example.collectionhm;


import com.example.collectionhm.model.Employee;
import com.example.collectionhm.service.serviceimple.DepartmentServiceImple;
import com.example.collectionhm.service.serviceimple.EmployeeServiceImple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DeportmentServiceTest {

    @Mock
    private EmployeeServiceImple employeeService;

    @InjectMocks
    private DepartmentServiceImple departmentService;

    @Test
    public void getDepartmenTest(){
        //создание тестовых данных
        List<Employee> mockEmployeeList = Arrays.asList(
                new Employee("John", "Doe", 50000, 1),
                new Employee("Jane", "Smith", 60000, 1),
                new Employee("Bob", "Johnson", 70000, 2)
        );

        when(employeeService.findAllEmployees()).thenReturn(mockEmployeeList);

        List<Employee> res = departmentService.getDepartaments(1);
        Assertions.assertEquals(2, res.size());
        Assertions.assertEquals("John", res.get(0).getFirstName());

        verify(employeeService).findAllEmployees();

    }

    @Test
    public void getSumSalaryDeportmentTest(){
        List<Employee> mockEmployeeList = Arrays.asList(
                new Employee("John", "Doe", 50000, 1),
                new Employee("Jane", "Smith", 60000, 1),
                new Employee("Bob", "Johnson", 70000, 2)
        );

        when(employeeService.findAllEmployees()).thenReturn(mockEmployeeList);

        int res =departmentService.getSumSalaryDepartament(1);

        Assertions.assertEquals(110000, res);
        verify(employeeService).findAllEmployees();
    }

    @Test
    public void getMaxSalaryDeportmentTest(){
        List<Employee> mockEmployeeList = Arrays.asList(
                new Employee("John", "Doe", 50000, 1),
                new Employee("Jane", "Smith", 60000, 1),
                new Employee("Bob", "Johnson", 70000, 2)
        );

        when(employeeService.findAllEmployees()).thenReturn(mockEmployeeList);

        Optional<Employee> res = departmentService.getMaxSalaryDepartament(1);

        Assertions.assertEquals(60000, res.get().getSalary());
    }

    @Test
    public void getMinSalaryDeportmentTest(){
        List<Employee> mockEmployeeList = Arrays.asList(
                new Employee("John", "Doe", 50000, 1),
                new Employee("Jane", "Smith", 60000, 1),
                new Employee("Bob", "Johnson", 70000, 2)
        );

        when(employeeService.findAllEmployees()).thenReturn(mockEmployeeList);

        Optional<Employee> res = departmentService.getMinSalaryDepartament(1);

        Assertions.assertEquals(50000, res.get().getSalary());
    }

    @Test void getAllDepartaments() {
        List<Employee> mockEmployeeList = Arrays.asList(
                new Employee("John", "Doe", 50000, 1),
                new Employee("Jane", "Smith", 60000, 1),
                new Employee("Bob", "Johnson", 70000, 2)
        );

        when(employeeService.findAllEmployees()).thenReturn(mockEmployeeList);

        Map<Integer, List<Employee>> res = departmentService.getAllDepartaments();

        Assertions.assertEquals(2, res.size());
    }


}
