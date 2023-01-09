package com.bookstore.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.bookstore.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    
}
