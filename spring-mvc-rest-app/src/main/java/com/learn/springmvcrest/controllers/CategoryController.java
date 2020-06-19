package com.learn.springmvcrest.controllers;

import com.learn.springmvcrest.api.v1.model.CategoryDTO;
import com.learn.springmvcrest.api.v1.model.CategoryListDTO;
import com.learn.springmvcrest.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/* using rest controller instead of controller. No need of returning  response entity, response type
gets auto converted into request type.
*/

@RestController
@RequestMapping("/api/v1/categories/")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CategoryListDTO getAllCategories() {
        return new CategoryListDTO(categoryService.getAllCategories());
    }

    @GetMapping("{name}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO getCategoryByName(@PathVariable String name) {
        return categoryService.getCategoryByName(name);
    }
}
