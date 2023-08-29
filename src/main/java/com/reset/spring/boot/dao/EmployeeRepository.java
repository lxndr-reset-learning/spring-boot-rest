package com.reset.spring.boot.dao;

import com.reset.spring.boot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> { // Employee -> employees (localhost:8080/employees)
}
