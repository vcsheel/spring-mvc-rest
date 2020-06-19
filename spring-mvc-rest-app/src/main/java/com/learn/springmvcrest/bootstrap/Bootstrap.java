package com.learn.springmvcrest.bootstrap;

import com.learn.springmvcrest.model.Category;
import com.learn.springmvcrest.model.Customer;
import com.learn.springmvcrest.model.Vendor;
import com.learn.springmvcrest.repository.CategoryRepository;
import com.learn.springmvcrest.repository.CustomerRepository;
import com.learn.springmvcrest.repository.VendorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;
    private final VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        loadCategories();
        loadCustomers();
        loadVendors();
    }

    private void loadCustomers() {
        Customer rob = new Customer();
        rob.setFirstName("Rob");
        rob.setLastName("Stark");

        Customer jon = new Customer();
        jon.setFirstName("Jon");
        jon.setLastName("Snow");

        Customer arya = new Customer();
        arya.setFirstName("Arya");
        arya.setLastName("Stark");

        customerRepository.save(rob);
        customerRepository.save(jon);
        customerRepository.save(arya);

        log.info("Customer data loaded: " + customerRepository.count());
    }

    private void loadCategories() {
        Category fruit = new Category();
        fruit.setName("Fruits");

        Category nuts = new Category();
        nuts.setName("Nuts");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category dried = new Category();
        dried.setName("Dried");

        categoryRepository.save(fruit);
        categoryRepository.save(nuts);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(dried);

        log.info("Category Data loaded : " + categoryRepository.count());
    }

    private void loadVendors() {
        Vendor vendor = new Vendor();
        vendor.setName("Vendor1");

        Vendor vendor1 = new Vendor();
        vendor1.setName("Vendor2");

        vendorRepository.save(vendor);
        vendorRepository.save(vendor1);

        log.info("Vendor data loaded: " + vendorRepository.count());
    }
}
