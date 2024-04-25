package com.example.angularspringbootproject.service;

import com.example.angularspringbootproject.db.EmployeeDb;
import com.example.angularspringbootproject.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDb employeeDb;

    public Employee saveEmployee(Employee employee){
        return employeeDb.save(employee);
    }
}
