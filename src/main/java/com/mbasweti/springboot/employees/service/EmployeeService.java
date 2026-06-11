package com.mbasweti.springboot.employees.service;

import java.util.List;

import com.mbasweti.springboot.employees.entity.Employee;

public interface EmployeeService {

    List<Employee> findAll();
    
}
