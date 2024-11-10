package com.learningMicroservices2.springBootCourse2.services;

import com.learningMicroservices2.springBootCourse2.entities.Product;

import java.util.List;

public interface ProductService{

    //método abstracto
    public List<Product> getProducts();

}
