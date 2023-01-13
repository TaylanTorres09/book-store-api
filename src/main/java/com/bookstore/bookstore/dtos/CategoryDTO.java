package com.bookstore.bookstore.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CategoryDTO {
    
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

}
