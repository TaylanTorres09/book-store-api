package com.bookstore.bookstore.dtos;

import com.bookstore.bookstore.models.Book;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class BookDTO {

    private Long id;

    @NotEmpty
    private String title;

    public BookDTO(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
    }
    
}
