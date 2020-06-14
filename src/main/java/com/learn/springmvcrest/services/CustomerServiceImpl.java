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

        return customerRepository.findById(id)
                .map(customerMapper::customerToCustomerDTO)
                .map(customerDTO -> {
                    customerDTO.setCustomUrl(API_V1_CUSTOMERS + customerDTO.getId());
                    return customerDTO;
                })
                .orElseThrow(RuntimeException::new);
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


    private CustomerDTO saveAndReturnDTO(Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);

        CustomerDTO returnCustomerDTO = customerMapper.customerToCustomerDTO(savedCustomer);
        returnCustomerDTO.setCustomUrl(API_V1_CUSTOMERS + savedCustomer.getId());

        return returnCustomerDTO;
    }


    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {

        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);

        return saveAndReturnDTO(customer);
    }


    @Override
    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
        Customer customerToUpdate = customerMapper.customerDTOToCustomer(customerDTO);
        customerToUpdate.setId(id);

        return saveAndReturnDTO(customerToUpdate);
    }

    @Override
    public CustomerDTO patchCustomer(Long id, CustomerDTO customerDTO) {

        return customerRepository.findById(id)
                .map(customer -> {

                    if(customerDTO.getFirstName() != null) {
                        customer.setFirstName(customerDTO.getFirstName());
                    }
                    if(customerDTO.getLastName() != null) {
                        customer.setLastName(customerDTO.getLastName());
                    }

                    return saveAndReturnDTO(customer);
                })
                .orElseThrow(RuntimeException::new);
    }
}
