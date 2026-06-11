package com.mbasweti.springboot.employees.dao;

import java.util.List;

import com.mbasweti.springboot.employees.entity.Employee;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(long theId);

    Employee save(Employee theEmployee);

    void deleteById(long theId);

}
