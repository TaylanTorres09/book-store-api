package com.bookstore.bookstore.dtos;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotEmpty;

public class RequestBook {

    @NotEmpty(message = "Campo TITULO é obrigatório")
    @Length(min = 3, max = 50, message = "O campo TITULO deverá ter entre 3 a 50 caracteres")
    private String title;

    @NotEmpty(message = "Campo NOME do AUTOR é obrigatório")
    @Length(min = 3, max = 50, message = "O campo NOME do AUTOR deverá ter entre 3 a 200 caracteres")
    private String author;

    @NotEmpty(message = "Campo TEXTO é obrigatório")
    @Length(min = 10, max = 1000000, message = "O campo TEXTO deverá ter entre 10 a 1.000.000 caracteres")
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