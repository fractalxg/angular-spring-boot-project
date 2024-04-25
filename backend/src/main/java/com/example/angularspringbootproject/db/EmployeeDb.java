package com.example.angularspringbootproject.db;

import com.example.angularspringbootproject.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDb extends CrudRepository<Employee, Integer> {
}
