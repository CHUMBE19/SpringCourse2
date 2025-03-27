package com.learningMicroservices2.springBootCourse2.repository;

import com.learningMicroservices2.springBootCourse2.entities.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest //Para testear clases con persistencia a la base de datos
class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    TestEntityManager testEntityManager;

    @BeforeEach // Indica que este método se ejecutará antes de correr las pruebas
    void setUp() {
        Employee employee = new Employee(100L, "Salvador100", "Chumbe", 24, "salv@gmail.com", "Backend Developer", true, "I'm ready for this");
        testEntityManager.merge(employee);
    }

    @Test
    public void findEmployeeByNameIgnoreCaseFound(){
        Optional<Employee> employee = employeeRepository.findByNameIgnoreCase("Salvador100");
        assertEquals(employee.get().getName(), "Salvador100");
    }

    @Test
    public void findEmployeeByNameIgnoreCaseNotFound(){
        Optional<Employee> employee = employeeRepository.findByNameIgnoreCase("SalvadorX");
        assertEquals(employee, Optional.empty());
    }



}