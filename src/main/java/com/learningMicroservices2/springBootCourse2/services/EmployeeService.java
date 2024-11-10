package com.learningMicroservices2.springBootCourse2.services;

import com.learningMicroservices2.springBootCourse2.entities.Employee;
import com.learningMicroservices2.springBootCourse2.entities.Product;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();
}
