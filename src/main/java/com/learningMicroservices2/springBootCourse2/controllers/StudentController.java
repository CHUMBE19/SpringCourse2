package com.learningMicroservices2.springBootCourse2.controllers;

import com.learningMicroservices2.springBootCourse2.entities.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private List<Student> Students = new ArrayList<>(Arrays.asList(
        new Student(1, "salvador1", "chumbe1", "921888594", "salvdor1@gmail.com", BigDecimal.ZERO, 24, "Information Security"),
        new Student(2, "salvador2", "chumbe2", "921888594", "salvdor2@gmail.com", BigDecimal.ZERO, 24, "Information Security"),
        new Student(3, "salvador3", "chumbe3", "921888594", "salvdor3@gmail.com", BigDecimal.ZERO, 24, "Information Security"),
        new Student(4, "salvador4", "chumbe4", "921888594", "salvdor4@gmail.com", BigDecimal.ZERO, 24, "Information Security"),
        new Student(5, "salvador5", "chumbe5", "921888594", "salvdor5@gmail.com", BigDecimal.ZERO, 24, "Information Security")
    ));

    @GetMapping("")   //Get all students using ResponseEntity
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(Students);
    }

    @GetMapping("/id/{id}") // "<?>" indicate that the type of response may vary
    public ResponseEntity<?> getStudentById(@PathVariable int id){
        for (Student s : Students){
            if (s.getId() == id){
                return ResponseEntity.ok(s);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student "+id+" not found");
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getStudentByName(@PathVariable String name){
        for (Student s : Students){
            if (s.getName()!=null && s.getName().equalsIgnoreCase(name)){
                return ResponseEntity.ok(s);
            }
        }   //Personalized message with ResponseEntity
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student "+name+" not found");
    }

    @PostMapping("")
    public ResponseEntity<?> createStudent(@RequestBody Student student){
        Students.add(student);
        //return ResponseEntity.status(HttpStatus.CREATED).body("user "+student.getId()+" was created successfully");
        URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/name/{name}")
                    .buildAndExpand(student.getName())
                    .toUri();
        return ResponseEntity.created(location).body(student);
    }

    @PutMapping("")
    public ResponseEntity<?> updateStudent(@RequestBody Student student){
        for (Student s : Students){
            if (s.getId() == student.getId()){
                s.setName(student.getName());
                s.setLastname(student.getLastname());
                s.setAge(student.getAge());
                s.setCourse(student.getCourse());
                s.setEmail(student.getEmail());
                s.setPhone(student.getPhone());
                s.setAverage(student.getAverage());
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build(); //Appropriate response code for put methods (204)
    }

    @PatchMapping("")
    public ResponseEntity<?> partialStudentUpdate(@RequestBody Student student) {
        for (Student s : Students){
            if (s.getId() == student.getId()){
                if (student.getAge() != null){ //student.getAge() != null ? s.setAge(student.getAge());
                    s.setAge(student.getAge());
                }
                if (student.getAverage() != null){
                    s.setAverage(student.getAverage());
                }
                if (student.getName() != null){
                    s.setName(student.getName());
                }
                if (student.getLastname() != null){
                    s.setLastname(student.getLastname());
                }
                if (student.getCourse() != null){
                    s.setCourse(student.getCourse());
                }
                if (student.getEmail() != null){
                    s.setEmail(student.getEmail());
                }
                if (student.getPhone() != null){
                    s.setPhone(student.getPhone());
                }
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable int id) {
        boolean removed = Students.removeIf(s -> s.getId() == id);
        if (removed) return ResponseEntity.noContent().build();  // Retorna 204 si se eliminó el usuario
        return ResponseEntity.notFound().build();  // Retorna 404 si no se encontró el usuario
    }



}
