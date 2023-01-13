package com.bookstore.bookstore.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookstore.dtos.CategoryDTO;
import com.bookstore.bookstore.models.Category;
import com.bookstore.bookstore.repositories.CategoryRepository;
import com.bookstore.bookstore.service.exceptions.ObjectNotFound;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getCategory() {
        return this.categoryRepository.findAll();
    }

    public Category getByIdCategory(Long id) {
        return this.categoryRepository.findById(id)
                    .orElseThrow(() -> new ObjectNotFound("Category id: " + id + ", not found."));
    }

    public Category create(CategoryDTO categoryDTO) {
        categoryDTO.setId(null);
        Category category = new Category();
        BeanUtils.copyProperties(categoryDTO, category);
        return this.categoryRepository.save(category);
    }

}
