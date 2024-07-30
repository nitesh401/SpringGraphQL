package com.customer.service;

import com.customer.entity.Customer;
import com.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public List<Customer> getProducts(){
        return repository.findAll();
    }

    public List<Customer> getProductsByCategory(String category){
        return repository.findByCategory(category);
    }


    public Customer updateStock(int id, String phoneNumber){

       Customer existingCustomer= repository.findById(id)
                .orElseThrow(()-> new RuntimeException("customer not found with id "+id));

       existingCustomer.setPhoneNumber(phoneNumber);
       return repository.save(existingCustomer);
    }

    public Customer receiveNewShipment(int id, int quantity){

        Customer existingProduct= repository.findById(id)
                .orElseThrow(()-> new RuntimeException("product not found with id "+id));

       existingProduct.setPhoneNumber(existingProduct.getPhoneNumber()+quantity);
        return repository.save(existingProduct);
    }
}
