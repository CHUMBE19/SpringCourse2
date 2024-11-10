package com.learningMicroservices2.springBootCourse2.controllers;

import com.learningMicroservices2.springBootCourse2.entities.Product;
import com.learningMicroservices2.springBootCourse2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    //Instancia de una clase
    //ProductService productService = new ProductServiceImpl();

    @Autowired  //Dependency injection
    @Qualifier("staticResourceService")      //To distinguish which interface implementation is to be injected
    private ProductService productService;

    @GetMapping("")
    public ResponseEntity<?> getAllProducts(){
        List<Product> products = productService.getProducts();
        return ResponseEntity.ok(products);
    }


}
