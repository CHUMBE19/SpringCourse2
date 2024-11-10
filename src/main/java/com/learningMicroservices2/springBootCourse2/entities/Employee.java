package com.learningMicroservices2.springBootCourse2.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="employees")
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastName;
    private Integer age;
    private String email;
    private String jobTitle;
    private Boolean active;
    private String comment;

    ///*
    public Employee(long id, String name, String lastName, Integer age, String email, String jobTitle, Boolean active, String comment) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.jobTitle = jobTitle;
        this.active = active;
        this.comment = comment;
    }
    public Employee() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    // */
}
