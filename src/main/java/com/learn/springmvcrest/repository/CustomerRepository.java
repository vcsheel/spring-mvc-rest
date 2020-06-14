package com.learn.springmvcrest.repository;

import com.learn.springmvcrest.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByLastName(String lastName);
}
