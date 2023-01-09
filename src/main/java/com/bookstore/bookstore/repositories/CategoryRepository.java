package com.bookstore.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.bookstore.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
