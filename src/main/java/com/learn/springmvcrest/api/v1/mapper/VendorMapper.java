package com.learn.springmvcrest.api.v1.mapper;

import com.learn.springmvcrest.api.v1.model.VendorDTO;
import com.learn.springmvcrest.model.Vendor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VendorMapper {

    VendorMapper INSTANCE = Mappers.getMapper(VendorMapper.class);

    VendorDTO vendorToVendorDTO (Vendor vendor);
    Vendor vendorDTOToVendor (VendorDTO vendorDTO);
}
