package com.bookstore.bookstore.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bookstore.bookstore.dtos.BookDTO;
import com.bookstore.bookstore.dtos.RequestBook;
import com.bookstore.bookstore.models.Book;
import com.bookstore.bookstore.service.BookService;

import jakarta.validation.Valid;

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

    @PostMapping("/create")
    public ResponseEntity<Book> create(@Valid @RequestBody RequestBook bookDTO) {
        Book book = this.bookService.create(bookDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path(String.format("/book/%d", book.getId())).buildAndExpand(book.getId()).toUri();
        
        //return uri in headers
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Book> update(@PathVariable Long id, @Valid @RequestBody RequestBook bookDTO) {
        Book book = this.bookService.update(id, bookDTO);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Book> updatePatch(@PathVariable Long id, @Valid @RequestBody RequestBook bookDTO) {
        Book book = this.bookService.update(id, bookDTO);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }
    
}
