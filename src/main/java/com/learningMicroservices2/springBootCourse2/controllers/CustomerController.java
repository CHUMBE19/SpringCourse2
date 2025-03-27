package com.learningMicroservices2.springBootCourse2.controllers;

import com.learningMicroservices2.springBootCourse2.entities.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    //STATIC DATA FOR PRACTICE
    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(1, "salvador", "salvamusic", "123456"),
            new Customer(2, "salvador2", "salvamusic2", "123456"),
            new Customer(3, "salvador3", "salvamusic3", "123456"),
            new Customer(4, "salvador4", "salvamusic4", "123456")
    ));

    //GET REQUESTS
    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping("")
    public List<Customer> getCustomers(){
      return customers;
    }

    //@RequestMapping(value = "/{username}", method = RequestMethod.GET)
    @GetMapping("/{username}")
    public Customer getCustomer(@PathVariable String username){
        for (Customer c: customers){
            if(c.getUsername().equalsIgnoreCase(username)){
                return c;
            }
        }
        return null; //only to example | it's a bad practice
    }

    //POST REQUESTS
    //@RequestMapping(method = RequestMethod.POST)
    @PostMapping("")
    public Customer addCustomer(@RequestBody Customer customer){
        customers.add(customer);
        return customer;
    }

    //PUT REQUESTS
    @PutMapping("")
    public Customer updateCustomer(@RequestBody Customer customer){
        for(Customer c : customers){
            if(c.getId() == customer.getId()){
                c.setName(customer.getName());
                c.setUsername(customer.getUsername());
                c.setPassword(customer.getPassword());
                return c;
            }
        }
        return null;
    }

    //DELETE MAPPING
    //@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    public Customer deleteCustomer(@PathVariable int id){
        for(Customer c : customers){
            if (c.getId() == id){
                customers.remove(c);
                return c;
            }
        }
        return null;
    }

    //PATCH MAPPING
    @PatchMapping("")
    public Customer updateCustomerUsername(@RequestBody Customer customer){
        for(Customer c : customers){
            if(c.getId() == customer.getId()){
                if (customer.getName() != null) { c.setName(customer.getName()); }
                if (customer.getUsername() != null) { c.setUsername(customer.getUsername()); }
                if (customer.getPassword() != null) { c.setPassword(customer.getPassword()); }
                return c;
            }
        }
        return null;
    }


}
