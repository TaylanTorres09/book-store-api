package com.bookstore.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.bookstore.dtos.CategoryDTO;
import com.bookstore.bookstore.models.Category;
import com.bookstore.bookstore.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> getCategory() {
        return this.categoryService.getCategory();
    }

    @GetMapping("/{id}")
    public Category getByIdCategory(@PathVariable(name = "id") Long id) {
        return this.categoryService.getByIdCategory(id);
    }

    @GetMapping
    public List<CategoryDTO> getCategoryWithOutBooks() {
        List<Category> categories = this.categoryService.getCategory();
        List<CategoryDTO> categoryDTOs = categories.stream()
                        .map(cat -> new CategoryDTO(cat.getId(), cat.getName(), cat.getDescription()))
                        .toList();
        return categoryDTOs;
    }

}
