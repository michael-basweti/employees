package com.mbasweti.springboot.employees.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mbasweti.springboot.employees.dao.EmployeeDAO;
import com.mbasweti.springboot.employees.entity.Employee;
import com.mbasweti.springboot.employees.request.EmployeeRequest;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    private EmployeeDAO employeeDAO;

    public EmployeeServiceImplementation(EmployeeDAO theEmployeeDAO) {
        this.employeeDAO = theEmployeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Employee theEmployee = employeeDAO.findById(theId);
        
        return theEmployee;
    }

    @Transactional
    @Override
    public Employee save(EmployeeRequest theEmployeeRequest) {
        Employee theEmployee = convertToEmployee(0, theEmployeeRequest);
        Employee dbEmployee = employeeDAO.save(theEmployee);
        return dbEmployee;
    }

    @Transactional
    @Override
    public Employee update(long id, EmployeeRequest theEmployeeRequest) {
        Employee theEmployee = convertToEmployee(id, theEmployeeRequest);
        Employee dbEmployee = employeeDAO.save(theEmployee);
        return dbEmployee;
    }

    @Override
    public Employee convertToEmployee(long id, EmployeeRequest theEmployeeRequest) {
        Employee theEmployee = new Employee();
        theEmployee.setId(id);
        theEmployee.setFirstName(theEmployeeRequest.getFirstName());
        theEmployee.setLastName(theEmployeeRequest.getLastName());
        theEmployee.setEmail(theEmployeeRequest.getEmail());
        return theEmployee;
    }

    @Override
    public void deleteById(int theId) {
        employeeDAO.deleteById(theId);
    }

    

}