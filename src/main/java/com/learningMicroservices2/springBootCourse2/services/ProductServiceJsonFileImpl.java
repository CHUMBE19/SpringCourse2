package com.learningMicroservices2.springBootCourse2.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learningMicroservices2.springBootCourse2.entities.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Primary
@Service("jsonResourceService")
public class ProductServiceJsonFileImpl implements ProductService{


    @Override
    public List<Product> getProducts() {
        List<Product> products;
        try{
            products = new ObjectMapper()
                    .readValue(this.getClass().getResourceAsStream("/products.json"), new TypeReference<List<Product>>() {});
            return products;
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }


}
