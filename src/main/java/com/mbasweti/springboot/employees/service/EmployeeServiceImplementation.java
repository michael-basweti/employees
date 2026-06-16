package com.mbasweti.springboot.employees.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mbasweti.springboot.employees.dao.EmployeeRepository;
import com.mbasweti.springboot.employees.entity.Employee;
import com.mbasweti.springboot.employees.request.EmployeeRequest;

@Service
public class EmployeeServiceImplementation implements EmployeeService {


    private EmployeeRepository employeeRepository;

    public EmployeeServiceImplementation(EmployeeRepository theEmployeeRepository) {
        this.employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(long theId) {
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;

        if(result.isPresent()) {
            theEmployee = result.get();
        }
        else {
            throw new RuntimeException("Did not find employee id - " + theId);
        }
        
        return theEmployee;
    }

    @Transactional
    @Override
    public Employee save(EmployeeRequest theEmployeeRequest) {
        Employee theEmployee = convertToEmployee(0, theEmployeeRequest);
        Employee dbEmployee = employeeRepository.save(theEmployee);
        return dbEmployee;
    }

    @Transactional
    @Override
    public Employee update(long id, EmployeeRequest theEmployeeRequest) {
        Employee theEmployee = convertToEmployee(id, theEmployeeRequest);
        Employee dbEmployee = employeeRepository.save(theEmployee);
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

    @Transactional
    @Override
    public void deleteById(long theId) {
        employeeRepository.deleteById(theId);
    }

    

}