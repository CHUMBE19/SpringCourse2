package com.learningMicroservices2.springBootCourse2.services;

import com.learningMicroservices2.springBootCourse2.entities.Employee;
import com.learningMicroservices2.springBootCourse2.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IEmployeeServiceTest {
    @Autowired // Inject a EmployeeService dependence
    private IEmployeeService IEmployeeService;
    @MockBean //Simulate a call to the database
    private EmployeeRepository employeeRepository;
    @BeforeEach //Method that is initialized before testing
    void setUp() {
        Employee employee = new Employee(101L, "Salvador101", "Chumbe", 24, "salv@gmail.com", "Backend Developer", true, "I'm ready for this");
        Mockito.when(employeeRepository.findByNameIgnoreCase("Salvador101")).thenReturn(Optional.of(employee));
    }

    @Test
    @DisplayName("Test that return a employee by valid name")
    public void findByNameIgnoreCaseFound(){
        String employeeName = "Salvador101";
        Employee employee = IEmployeeService.findByNameIgnoreCase(employeeName).get();
        assertEquals(employeeName, employee.getName());
        System.out.println("Employee: " + employee);
    }


}