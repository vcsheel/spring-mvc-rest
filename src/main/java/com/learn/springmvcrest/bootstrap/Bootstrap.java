package com.learn.springmvcrest.bootstrap;

import com.learn.springmvcrest.model.Category;
import com.learn.springmvcrest.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    public Bootstrap(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {

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

        log.info("Data loaded : " + categoryRepository.count());
    }
}
