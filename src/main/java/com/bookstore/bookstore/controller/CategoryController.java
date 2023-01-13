package com.bookstore.bookstore.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bookstore.bookstore.dtos.CategoryDTO;
import com.bookstore.bookstore.models.Category;
import com.bookstore.bookstore.service.CategoryService;

import jakarta.validation.Valid;

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

    @PostMapping("/create")
    public ResponseEntity<Category> create(@Valid @RequestBody CategoryDTO categoryDTO) {
        Category category = this.categoryService.create(categoryDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/category/{id}").buildAndExpand(category.getId()).toUri();
        
        //return uri in headers
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Category> update(@Valid @RequestBody CategoryDTO categoryDTO, @PathVariable Long id) {
        Category category = this.categoryService.update(categoryDTO, id);
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return this.categoryService.delete(id);
    }

}
