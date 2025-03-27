package com.learningMicroservices2.springBootCourse2.repository;

import com.learningMicroservices2.springBootCourse2.entities.Employee;
import com.learningMicroservices2.springBootCourse2.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.name = :name") //Custom queries with JPQL
    Optional<Employee> getEmployeeByName(String name);

    Optional<Employee> findByName(String name);

    Optional<Employee> findByNameIgnoreCase(String name);

    @Query("SELECT e FROM Employee e WHERE e.active = true")
    Optional<List<Employee>> findActives();

    @Query("SELECT e FROM Employee e WHERE e.age > 17")
    Optional<List<Employee>> findOlds();

    @Query("SELECT e FROM Employee e WHERE e.age = :age")
    Optional<List<Employee>> findByAge(Integer age);

    @Query("SELECT e FROM Employee e WHERE e.age between :from and :to")
    Optional<List<Employee>> findAgeRange(Integer from, Integer to);

    @Query("SELECT e FROM Employee e WHERE e.name like :name%") //Custom queries with JPQL
    Optional<List<Employee>> findByNameParents(String name);

    @Query("SELECT name FROM Employee")
    List<String> getEmployeeNames();
}
