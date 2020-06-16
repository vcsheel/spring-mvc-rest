package com.learn.springmvcrest.api.v1.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CustomerDTO {
    private Long id;

    @ApiModelProperty(value = "First Name of customer", required = true)
    private String firstName;
    private String lastName;
    private String customUrl;
}
