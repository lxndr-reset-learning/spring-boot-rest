package com.reset.spring.boot.dao;

import com.reset.spring.boot.entity.Employee;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * EmployeeDAOImpl is an implementation class of the EmployeeDAO interface.
 * It provides various methods for accessing and manipulating Employee objects in the database.
 * This class uses Hibernate and Spring framework for database operations.
 * Also in this code, the decision was made to drop the use of Hibernate to follow best practices
 * */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired
    private EntityManager entityManager; // creates automatically by Spring


    @Override
    public List<Employee> getAllEmployees() {
        Session session = entityManager.unwrap(Session.class); // entityManager is a wrapper of session, so we unwrap it
        Query<Employee> query = session.createQuery("from Employee", Employee.class);

        return query.getResultList();
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = entityManager.unwrap(Session.class);
        session.merge(employee);
    }

    @Override
    public Employee getEmployeeById(int id) {
        Session session = entityManager.unwrap(Session.class);

        return session.get(Employee.class, id);
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query<Employee> query = session.createQuery("delete from Employee where id = :id", Employee.class);
        query.setParameter(":id", id);

        query.executeUpdate();

    }
}
