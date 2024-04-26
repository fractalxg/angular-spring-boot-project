package com.example.angularspringbootproject.controller;

import com.example.angularspringbootproject.entity.Employee;
import com.example.angularspringbootproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save/employee")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/get/employee")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/get/employee/{employeeId}")
    public Employee getEmployee(@PathVariable Integer employeeId){
        return employeeService.getEmployees(employeeId);
    }
}
