package com.bookstore.bookstore.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CategoryDTO {
    
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

}
