package com.learningMicroservices2.springBootCourse2.controllers;

import com.learningMicroservices2.springBootCourse2.entities.Employee;
import com.learningMicroservices2.springBootCourse2.entities.Product;
import com.learningMicroservices2.springBootCourse2.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private static final String template = "Hello %s";
    private final AtomicLong counter = new AtomicLong(); //For generate unque id

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/greeting") //Dynamic endpoint, useful for filters
    public Employee getEmployeeGreeting(@RequestParam(value = "name", defaultValue = "world") String name){
        Employee employee = new Employee(counter.incrementAndGet(), name, null, null,null,null,null,String.format(template, name));
        System.out.println("Employee name: " + employee.getName());
        return employee;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllEmployees(){
        return ResponseEntity.ok(employeeService.getEmployees());
    }

}
