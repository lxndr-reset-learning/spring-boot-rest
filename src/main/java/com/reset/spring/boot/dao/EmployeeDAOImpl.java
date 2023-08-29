package com.reset.spring.boot.dao;

import com.reset.spring.boot.entity.Employee;
import com.reset.spring.boot.entity.EmployeeRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * EmployeeDAOImpl is an implementation class of the EmployeeDAO interface.
 * It provides various methods for accessing and manipulating Employee objects in the database.
 * This class uses Hibernate and Spring framework for database operations.
 * Also in this code, the decision was made to drop the use of Hibernate to follow best practices
 */
@Component
public class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired
    private EntityManager entityManager; // creates automatically by Spring
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null); //if we don't use .orElse(), we have to use Optional
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

}
