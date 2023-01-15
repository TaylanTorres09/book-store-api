package com.bookstore.bookstore.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookstore.dtos.RequestBook;
import com.bookstore.bookstore.models.Book;
import com.bookstore.bookstore.models.Category;
import com.bookstore.bookstore.repositories.BookRepository;
import com.bookstore.bookstore.service.exceptions.ObjectNotFound;

import jakarta.validation.Valid;

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

    public Book create(RequestBook bookDTO) {
        Book book = new Book();
        book.setId(null);
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setText(bookDTO.getText());

        Category category = this.categoryService.getByIdCategory(bookDTO.getCategoryId());
        book.setCategory(category);

        return this.bookRepository.save(book);
    }

    public Book update(Long id, RequestBook bookDTO) {
        Book book = this.getByIdBook(id);

        BeanUtils.copyProperties(bookDTO, book);

        return this.bookRepository.save(book);
    }



}
