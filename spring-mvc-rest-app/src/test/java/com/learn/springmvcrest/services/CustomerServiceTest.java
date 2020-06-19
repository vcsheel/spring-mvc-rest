package com.learn.springmvcrest.services;

import com.learn.springmvcrest.api.v1.mapper.CustomerMapper;
import com.learn.springmvcrest.api.v1.model.CustomerDTO;
import com.learn.springmvcrest.model.Customer;
import com.learn.springmvcrest.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class CustomerServiceTest {

    private final String FIRSTNAME = "Rob";
    private final Long ID = 1L;

    @Mock
    CustomerMapper customerMapper;

    @Mock
    CustomerRepository customerRepository;

    CustomerService customerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        customerService = new CustomerServiceImpl(customerRepository, CustomerMapper.INSTANCE);
    }

    @Test
    void findById() {
        Customer customer = new Customer();
        customer.setFirstName(FIRSTNAME);
        customer.setId(ID);

        when(customerRepository.findById(anyLong())).thenReturn(Optional.of(customer));

        CustomerDTO customerDTO = customerService.findById(ID);

        assertNotNull(customerDTO);
        assertEquals(FIRSTNAME, customerDTO.getFirstName());
    }

    @Test
    void getAllCustomers() {
        List<Customer> customers = Arrays.asList(new Customer(), new Customer());

        when(customerRepository.findAll()).thenReturn(customers);

        List<CustomerDTO> customerDTOS = customerService.getAllCustomers();

        assertEquals(2, customerDTOS.size());
    }

    @Test
    void createNewCustomer() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName(FIRSTNAME);

        Customer customer = new Customer();
        customer.setFirstName(customerDTO.getFirstName());
        customer.setId(ID);

        when(customerRepository.save(any())).thenReturn(customer);

        CustomerDTO savedDTO = customerService.createCustomer(customerDTO);

        assertEquals(FIRSTNAME, savedDTO.getFirstName());
    }
}