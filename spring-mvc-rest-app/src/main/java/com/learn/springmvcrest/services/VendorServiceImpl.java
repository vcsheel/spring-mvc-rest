package com.learn.springmvcrest.services;

import com.learn.springmvcrest.api.v1.mapper.VendorMapper;
import com.learn.springmvcrest.api.v1.model.VendorDTO;
import com.learn.springmvcrest.model.Vendor;
import com.learn.springmvcrest.repository.VendorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepository;
    private final VendorMapper vendorMapper;

    public VendorServiceImpl(VendorRepository vendorRepository, VendorMapper vendorMapper) {
        this.vendorRepository = vendorRepository;
        this.vendorMapper = vendorMapper;
    }

    @Override
    public List<VendorDTO> getAllVendors() {
        return vendorRepository.findAll()
                .stream()
                .map(vendorMapper::vendorToVendorDTO)
                .collect(Collectors.toList());
    }

    @Override
    public VendorDTO getVendorById(Long id) {
        return vendorRepository.findById(id)
                .map(vendorMapper::vendorToVendorDTO)
                .orElseThrow(ResourceNotFoundException::new);
    }

    private VendorDTO saveOrUpdateVendor (Vendor vendor) {
        Vendor savedVendor = vendorRepository.save(vendor);
        return vendorMapper.vendorToVendorDTO(savedVendor);
    }

    @Override
    public VendorDTO createVendor(VendorDTO vendorDTO) {
        Vendor vendorToSave = vendorMapper.vendorDTOToVendor(vendorDTO);
        return saveOrUpdateVendor(vendorToSave);
    }

    @Override
    public VendorDTO updateVendor(Long id, VendorDTO vendorDTO) {
        Vendor vendorToUpdate = vendorMapper.vendorDTOToVendor(vendorDTO);
        vendorToUpdate.setId(id);
        return saveOrUpdateVendor(vendorToUpdate);
    }

    @Override
    public VendorDTO patchVendor(Long id, VendorDTO vendorDTO) {
        return null;
    }

    @Override
    public void deleteVendor(Long id) {
        vendorRepository.deleteById(id);
    }
}
