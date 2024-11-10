package com.learningMicroservices2.springBootCourse2.services;

import com.learningMicroservices2.springBootCourse2.entities.Employee;
import com.learningMicroservices2.springBootCourse2.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public ResponseEntity<?> updateEmployee(Long id, Employee employee) {
        Employee findEmployee = employeeRepository.findById(id).orElse(null);
        if(findEmployee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
        }
        if(Objects.nonNull(employee.getAge()) && employee.getAge()>0 && employee.getAge() < 100 ){
            findEmployee.setAge(employee.getAge());
        }
        if(Objects.nonNull(employee.getName()) && !"".equalsIgnoreCase(employee.getName())){
            findEmployee.setName(employee.getName());
        }
        if(Objects.nonNull(employee.getLastName()) && !"".equalsIgnoreCase(employee.getLastName())){
            findEmployee.setLastName(employee.getLastName());
        }
        if(Objects.nonNull(employee.getEmail()) && !"".equalsIgnoreCase(employee.getEmail())){
            findEmployee.setEmail(employee.getEmail());
        }
        if(Objects.nonNull(employee.getJobTitle()) && !"".equalsIgnoreCase(employee.getJobTitle())){
            findEmployee.setJobTitle(employee.getJobTitle());
        }
        if(Objects.nonNull(employee.getActive())){
            findEmployee.setActive(employee.getActive());
        }
        if(Objects.nonNull(employee.getComment()) && !"".equalsIgnoreCase(employee.getComment())){
            findEmployee.setComment(employee.getComment());
        }
        employeeRepository.save(findEmployee);
        return ResponseEntity.ok("Employee " + findEmployee.getId() + " was updated successfully");
        //return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<?> deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee with ID " + id + " not found"));
        employeeRepository.delete(employee);
        return ResponseEntity.ok("Employee " + id + " was removed successfully");
    }


}
