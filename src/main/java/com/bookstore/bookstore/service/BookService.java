package com.bookstore.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookstore.models.Book;
import com.bookstore.bookstore.repositories.BookRepository;
import com.bookstore.bookstore.service.exceptions.ObjectNotFound;

@Service
public class BookService {
    
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryService categoryService;

    public List<Book> getBooks() {
        return this.bookRepository.findAll();
    }

    public Book getByIdBook(Long id) {
        return this.bookRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFound("Book id: " + id + ", not Found."));
    }

    public List<Book> findByCategory(Long idCategory) {
        this.categoryService.getByIdCategory(idCategory);
        return this.bookRepository.findByCategory(idCategory);
    }

}
