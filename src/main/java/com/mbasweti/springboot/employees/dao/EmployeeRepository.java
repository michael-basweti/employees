package com.mbasweti.springboot.employees.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mbasweti.springboot.employees.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // No additional methods are needed as JpaRepository provides basic CRUD operations
}
