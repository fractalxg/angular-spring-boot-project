package com.example.angularspringbootproject.service;

import com.example.angularspringbootproject.db.EmployeeDb;
import com.example.angularspringbootproject.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDb employeeDb;

    public Employee saveEmployee(Employee employee){
        return employeeDb.save(employee);
    }

    public List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        employeeDb.findAll().forEach(employees::add);
        return employees;
    }

    public Employee getEmployees(Integer employeeId){
        return employeeDb.findById(employeeId).orElseThrow();
    }
}
