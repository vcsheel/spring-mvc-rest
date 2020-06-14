package com.learn.springmvcrest.api.v1.mapper;

import com.learn.springmvcrest.api.v1.model.CustomerDTO;
import com.learn.springmvcrest.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO customerToCustomerDTO (Customer customer);
}
