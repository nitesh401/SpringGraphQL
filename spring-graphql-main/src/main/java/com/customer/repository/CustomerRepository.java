package com.customer.repository;

import com.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    List<Customer> findByCategory(String category);
}
