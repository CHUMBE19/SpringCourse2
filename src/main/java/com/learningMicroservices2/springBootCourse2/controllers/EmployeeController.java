package com.learningMicroservices2.springBootCourse2.controllers;

import com.learningMicroservices2.springBootCourse2.Error.EmployeeNotFoundException;
import com.learningMicroservices2.springBootCourse2.entities.Employee;
import com.learningMicroservices2.springBootCourse2.services.IEmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private static final String template = "Hello %s";
    private final AtomicLong counter = new AtomicLong(); //For generate unque id

    @Autowired
    IEmployeeService IEmployeeService;

    @GetMapping("/greeting") //Dynamic endpoint, useful for filters
    public Employee getEmployeeGreeting(@RequestParam(value = "name", defaultValue = "world") String name){
        Employee employee = new Employee(counter.incrementAndGet(), name, null, null,null,null,null,String.format(template, name));
        System.out.println("Employee name: " + employee.getName());
        return employee;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllEmployees(){
        return ResponseEntity.ok(IEmployeeService.getEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) throws EmployeeNotFoundException {
        return ResponseEntity.ok(IEmployeeService.findById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getByName(@PathVariable String name){
        return ResponseEntity.ok(IEmployeeService.getEmployeeByName(name));
    }

    @GetMapping("/nameJpa/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name){
        return ResponseEntity.ok(IEmployeeService.findByName(name));
    }

    @GetMapping("/nameIgnoreCase/{name}")
    public ResponseEntity<?> findByNameIgnoreCase(@PathVariable String name){
        return ResponseEntity.ok(IEmployeeService.findByNameIgnoreCase(name));
    }

    @GetMapping("/actives")
    public ResponseEntity<?> findByActives(){
        return ResponseEntity.ok(IEmployeeService.findByActives());
    }

    @GetMapping("/age/{age}")
    public ResponseEntity<?> findByAge(@PathVariable Integer age){
        return ResponseEntity.ok(IEmployeeService.findByAge(age));
    }

    @GetMapping("/nameParents/{name}")
    public ResponseEntity<?> findByNameParents(@PathVariable String name){
        return ResponseEntity.ok(IEmployeeService.findByNameParents(name));
    }

    @GetMapping("/age_range") //With RequestParam
    public ResponseEntity<?> findByAgeRange(@RequestParam(required = false) Integer minAge, @RequestParam(required = false) Integer maxAge){
        return ResponseEntity.ok(IEmployeeService.findByAgeRange(minAge, maxAge));
    }

    @GetMapping("/age_range/{minAge}/{maxAge}") //With Path (Required minAge and maxAge)
    public ResponseEntity<?> findByAgeRange2(@PathVariable Integer minAge, @PathVariable Integer maxAge){
        return ResponseEntity.ok(IEmployeeService.findByAgeRange(minAge, maxAge));
    }

    @GetMapping("/age/olds")
    public ResponseEntity<?> findOlds(){
        return ResponseEntity.ok(IEmployeeService.findOlds());
    }

    @PostMapping("/create")
    public  ResponseEntity<?> createEmployee(@Valid  @RequestBody Employee employee){
        return ResponseEntity.ok(IEmployeeService.saveEmployee(employee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        return ResponseEntity.ok(IEmployeeService.updateEmployee(id, employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id){
        return ResponseEntity.ok(IEmployeeService.deleteEmployee(id));
    }

    //EXERCISES

    @GetMapping("/reverse_name/{name}")
    public ResponseEntity<?> reverseName(@PathVariable String name){
        return ResponseEntity.ok(IEmployeeService.reverseName(name));
    }

    @GetMapping("/employee_names") //Transform
    public ResponseEntity<?> getEmployeeNames(){
        return ResponseEntity.ok(IEmployeeService.getEmployeeNames());
    }

    @GetMapping("/employee_names_2")
    public ResponseEntity<?> getEmployeeNames2(){ //From DB
        return ResponseEntity.ok(IEmployeeService.getEmployeeNames2());
    }



}
