package com.learningMicroservices2.springBootCourse2.Error;

public class EmployeeNotFoundException extends Exception{
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
