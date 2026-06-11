package com.mbasweti.springboot.employees.service;

import java.util.List;

import com.mbasweti.springboot.employees.entity.Employee;
import com.mbasweti.springboot.employees.request.EmployeeRequest;


public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(EmployeeRequest theEmployeeRequest);

    Employee update(long id, EmployeeRequest theEmployeeRequest);

    Employee convertToEmployee(long id, EmployeeRequest theEmployeeRequest);

    void deleteById(int theId);

}
