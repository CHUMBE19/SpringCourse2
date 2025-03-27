package com.learningMicroservices2.springBootCourse2.services;

import com.learningMicroservices2.springBootCourse2.Error.EmployeeNotFoundException;
import com.learningMicroservices2.springBootCourse2.entities.Employee;
import com.learningMicroservices2.springBootCourse2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeByName(String name) {
        return employeeRepository.getEmployeeByName(name);
    }

    @Override
    public Optional<Employee> findByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public Optional<Employee> findByNameIgnoreCase(String name) {
        return employeeRepository.findByNameIgnoreCase(name);
    }

    @Override
    public Employee findById(Long id) throws EmployeeNotFoundException{
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isEmpty()){
            throw new EmployeeNotFoundException("Employee " +id+ " not found");
        }
        return employee.get();
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
        return ResponseEntity.ok(findEmployee);
    }

    @Override
    public String deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        String response = "Employee " + id +" not found";
        if (employee != null) {
            employeeRepository.delete(employee);
            response = "Employee " +  id + " was removed successfully";
        }
        return response;
    }

    @Override
    public Optional<List<Employee>> findByActives(){
        return employeeRepository.findActives();
    }

    @Override
    public Optional<List<Employee>> findOlds(){
        return employeeRepository.findOlds();
    }
    @Override
    public Optional<List<Employee>> findByAge(Integer age){
        return employeeRepository.findByAge(age);
    }

    @Override
    public Optional<List<Employee>> findByAgeRange(Integer minAge, Integer maxAge){
        if(minAge == null) minAge = 0;
        if(maxAge == null) maxAge = 100;
        return employeeRepository.findAgeRange(minAge, maxAge);
    }

    @Override
    public Optional<List<Employee>> findByNameParents(String name){
        return employeeRepository.findByNameParents(name);
    }

    @Override
    public String reverseName (String name){
        String[] arrayString = name.split("");
        StringBuilder invertName = new StringBuilder();
        for(int i = arrayString.length; i > 0; i-- ){
           invertName.append(arrayString[i-1]);
        }
        return invertName.toString();
    }

    @Override
    public List<String> getEmployeeNames(){
        List<Employee> employees = employeeRepository.findAll();
        List<String> arrayNames = new ArrayList<>();
        for (int i = 0; i < employees.toArray().length; i++){
            arrayNames.add(employees.get(i).getName());
        }
        return arrayNames;
    }

    @Override
    public List<String> getEmployeeNames2(){
        return employeeRepository.getEmployeeNames();
    }
}
