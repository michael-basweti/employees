package com.mbasweti.springboot.employees.dao;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.mbasweti.springboot.employees.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOJpaImplementation implements EmployeeDAO {

    private EntityManager entityManager;

    public EmployeeDAOJpaImplementation(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

     @Override
    public List<Employee> findAll() {
        // create a query
        
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        // execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        // return the results
        return employees;
    }

     @Override
     public Employee findById(long theId) {
        Employee theEmployee = entityManager.find(Employee.class, theId);
        return theEmployee;
     }

     @Override
     public Employee save(Employee theEmployee) {
        Employee dbEmployee = entityManager.merge(theEmployee);
        return dbEmployee;
     }

     @Override
     public void deleteById(long theId) {
        Employee theEmployee = entityManager.find(Employee.class, theId);
        entityManager.remove(theEmployee);
     }

}
