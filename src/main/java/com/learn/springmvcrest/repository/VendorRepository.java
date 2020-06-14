package com.learn.springmvcrest.repository;

import com.learn.springmvcrest.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
