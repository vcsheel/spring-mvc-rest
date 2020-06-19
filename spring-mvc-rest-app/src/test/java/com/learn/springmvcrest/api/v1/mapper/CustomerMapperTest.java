package com.learn.springmvcrest.api.v1.mapper;

import com.learn.springmvcrest.api.v1.model.CustomerDTO;
import com.learn.springmvcrest.model.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerMapperTest {

    private final String FIRSTNAME =  "Danny";
    private final String LASTNAME = "Targereon";
    private final Long ID = 1L;

    CustomerMapper customerMapper = CustomerMapper.INSTANCE;


    @Test
    void customerToCustomerDTO() {
        Customer customer = new Customer();
        customer.setId(ID);
        customer.setFirstName(FIRSTNAME);
        customer.setLastName(LASTNAME);

        //when
        CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);

        assertEquals(FIRSTNAME, customerDTO.getFirstName());
        assertEquals(ID, customerDTO.getId());
    }

    @Test
    void customerDTOToCustomer() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(ID);
        customerDTO.setFirstName(FIRSTNAME);

        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);

        assertEquals(ID, customer.getId());
    }
}