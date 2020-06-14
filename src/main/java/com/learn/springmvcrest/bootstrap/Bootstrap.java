package com.learn.springmvcrest.bootstrap;

import com.learn.springmvcrest.model.Category;
import com.learn.springmvcrest.model.Customer;
import com.learn.springmvcrest.repository.CategoryRepository;
import com.learn.springmvcrest.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        loadCategories();
        loadCustomers();
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
}
