package com.learn.springmvcrest.services;


import com.learn.model.CustomerDTO;

import java.util.List;

public interface CustomerService {

    CustomerDTO findById(Long id);

    List<CustomerDTO> getAllCustomers();

    CustomerDTO createCustomer(CustomerDTO customerDTO);

    CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO);

    CustomerDTO patchCustomer (Long id, CustomerDTO customerDTO);

    void  deleteCustomer (Long id);
}
