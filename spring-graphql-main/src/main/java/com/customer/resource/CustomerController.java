package com.customer.resource;

import com.customer.entity.Customer;
import com.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService service;


    @QueryMapping
    public List<Customer> getProducts() {
        return service.getProducts();
    }

    @QueryMapping
    public List<Customer> getProductsByCategory(@Argument String category) {
        return service.getProductsByCategory(category);
    }


    @MutationMapping
    public Customer updateStock(@Argument int id, @Argument String phoneNumber) {
        return service.updateStock(id, phoneNumber);

    }

    @MutationMapping
    @SubscriptionMapping
    public Customer receiveNewShipment(@Argument int id, @Argument int quantity) {
        return service.receiveNewShipment(id, quantity);

    }
}
