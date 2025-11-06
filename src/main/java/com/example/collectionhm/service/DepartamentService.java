package com.example.collectionhm.service;

import com.example.collectionhm.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface DepartamentService {

    public List<Employee> getDepartaments(int departmentId);

    public int getSumSalaryDepartament(int departmentId);

    public Optional<Employee> getMaxSalaryDepartament(int departmentId);

    public Optional<Employee> getMinSalaryDepartament(int departmentId);

    public Map<Integer, List<Employee>> getAllDepartaments();
}
