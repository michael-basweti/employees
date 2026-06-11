package com.mbasweti.springboot.employees.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mbasweti.springboot.employees.entity.Employee;
import com.mbasweti.springboot.employees.request.EmployeeRequest;
import com.mbasweti.springboot.employees.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@RestController
@RequestMapping("/api/employees")
@Tag(name = "Employee API", description = "API for managing employees")
public class EmployeeRestController {

    private EmployeeService employeeService;


    public EmployeeRestController(EmployeeService theEmployeeService) {
        this.employeeService = theEmployeeService;
    }


    @Operation(summary = "Get all employees", description = "Returns a list of all employees")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Employee> findAll() {
        return employeeService.findAll();
    }


    @Operation(summary = "Get employee by ID", description = "Returns an employee based on their ID")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{employeeId}")
    public Employee getEmployeeById(@PathVariable @Min(value = 1, message = "Employee ID must be a positive integer") long employeeId) {
        return employeeService.findById(employeeId);
    }


    @Operation(summary = "Add employee", description = "Adds a new employee")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public Employee addEmployee(@Valid @RequestBody EmployeeRequest theEmployee) {
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

}
