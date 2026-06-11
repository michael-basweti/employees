package com.mbasweti.springboot.employees.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mbasweti.springboot.employees.entity.Employee;
import com.mbasweti.springboot.employees.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

    private EmployeeService employeeService;


    public EmployeeRestController(EmployeeService theEmployeeService) {
        this.employeeService = theEmployeeService;
    }


    @GetMapping
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

}
