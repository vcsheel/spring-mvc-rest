package com.learn.springmvcrest.services;

import com.learn.springmvcrest.api.v1.mapper.CustomerMapper;
import com.learn.springmvcrest.api.v1.model.CustomerDTO;
import com.learn.springmvcrest.model.Customer;
import com.learn.springmvcrest.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService{

    public static final String API_V1_CUSTOMERS = "/api/v1/customers/";
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerDTO findById(Long id) {
        return customerMapper.customerToCustomerDTO(customerRepository.findById(id).get());
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customer -> {
                    
                    CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);
                    customerDTO.setCustomUrl(API_V1_CUSTOMERS + customer.getId());
                    return customerDTO;
                    
                })
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {

        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);

        Customer savedCustomer = customerRepository.save(customer);

        return customerMapper.customerToCustomerDTO(savedCustomer);
    }
}
