package com.learningMicroservices2.springBootCourse2.services;

import com.learningMicroservices2.springBootCourse2.Error.EmployeeNotFoundException;
import com.learningMicroservices2.springBootCourse2.entities.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getEmployees();
    Optional <Employee> getEmployeeByName(String name);
    Optional <Employee> findByName(String name);
    Optional <Employee> findByNameIgnoreCase(String name);
    Employee findById(Long id) throws EmployeeNotFoundException;
    ResponseEntity<?> updateEmployee(Long id, Employee employee);
    String deleteEmployee(Long id);
    Optional<List<Employee>> findByActives();
    Optional<List<Employee>> findOlds();
    Optional<List<Employee>> findByAge(Integer age);
    Optional<List<Employee>> findByAgeRange(Integer minAge, Integer maxAge);
    Optional<List<Employee>> findByNameParents(String name);
    String reverseName(String name);
    List<String> getEmployeeNames();
    List<String> getEmployeeNames2();
}
