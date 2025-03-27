package com.learningMicroservices2.springBootCourse2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String HelloWorld() {
        return "Hello World from Spring Boot";
    }

    @GetMapping({"/hello2", "/hw", "/h2"})
    public String HelloWorld2() {
        return "Hello World from Spring Boot whit many parameters (/hello, /hw, /h2)";
    }

    @GetMapping("/greeting/{name}") //Dynamic urls
    public String Greeting(@PathVariable String name){
        return "Hello "+name;
    }

    @GetMapping("/palindrome/{word}")
    public String Palindrome(@PathVariable String word){
        if(isPalindrome(word)){
            return "La palabra " + word + " es un palíndromo";
        }
        return "La palabra " + word + " no es un palíndromo";
    }

    public Boolean isPalindrome(String word){
        int length = word.length();
        for (int i = 0; i < length/2; i++){
            if(word.charAt(i) != (word.charAt(length - 1 - i))){
                return false;
            }
        }
        return true;
    }

}
