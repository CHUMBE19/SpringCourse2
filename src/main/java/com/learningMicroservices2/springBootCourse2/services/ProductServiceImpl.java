package com.learningMicroservices2.springBootCourse2.services;

import com.learningMicroservices2.springBootCourse2.entities.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("staticResourceService")
public class ProductServiceImpl implements IProductService {

    private List<Product> products = new ArrayList<>(Arrays.asList(
        new Product(1,"Computer", new BigDecimal("1100.00"), 20),
        new Product(2,"SmartPhone", new BigDecimal("800.00"), 20),
        new Product(3,"SmartWatch", new BigDecimal("200.00"), 20),
        new Product(4,"SmartGlasses", new BigDecimal("100.00"), 20)
    ));

    @Override
    public List<Product> getProducts() {
        return products;
    }

}
