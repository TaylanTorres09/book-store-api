package com.bookstore.bookstore.dtos;

import jakarta.validation.constraints.NotEmpty;

public class RequestBook {

    @NotEmpty
    private String title;

    @NotEmpty
    private String author;

    @NotEmpty
    private String text;

    private Long categoryId;

    public String getTitle() {
        return title;
    }
    
    public Long getCategoryId() {
        return categoryId;
    }
    public String getAuthor() {
        return author;
    }
    public String getText() {
        return text;
    }

}