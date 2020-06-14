package com.learn.springmvcrest.services;

import com.learn.springmvcrest.api.v1.model.CustomerDTO;

import java.util.List;

public interface CustomerService {

    CustomerDTO findById(Long id);

    List<CustomerDTO> getAllCustomers();

    CustomerDTO createCustomer(CustomerDTO customerDTO);
}
