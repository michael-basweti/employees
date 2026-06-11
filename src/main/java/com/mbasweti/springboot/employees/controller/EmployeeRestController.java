package com.mbasweti.springboot.employees.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mbasweti.springboot.employees.dao.EmployeeDAO;
import com.mbasweti.springboot.employees.entity.Employee;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

    private EmployeeDAO employeeDAO;

    
    public EmployeeRestController(EmployeeDAO theEmployeeDAO) {
        this.employeeDAO = theEmployeeDAO;
    }


    @GetMapping
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

}
