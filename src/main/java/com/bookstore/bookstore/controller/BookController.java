package com.bookstore.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.bookstore.dtos.BookDTO;
import com.bookstore.bookstore.models.Book;
import com.bookstore.bookstore.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getBooks() {
        return this.bookService.getBooks();
    }

    @GetMapping("/{id}")
    public Book getByIdBook(@PathVariable(name = "id") Long id) {
        return this.bookService.getByIdBook(id);
    }
    
    @GetMapping
    public ResponseEntity<List<BookDTO>> findByCategory(@RequestParam(value = "category", defaultValue = "0") Long idCategory) {
        List<Book> books = this.bookService.findByCategory(idCategory);
        List<BookDTO> bookDTOs = books.stream().map(book -> new BookDTO(book)).toList();

        return new ResponseEntity<List<BookDTO>>(bookDTOs, HttpStatus.OK);
    }
    
}
