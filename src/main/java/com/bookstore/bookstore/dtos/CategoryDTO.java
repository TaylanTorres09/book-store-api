package com.bookstore.bookstore.dtos;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CategoryDTO {
    
    private Long id;

    @NotEmpty(message = "Campo NOME é obrigatório")
    @Length(min = 3, max = 100, message = "O campo NOME deverá ter entre 3 a 100 caracteres")
    private String name;

    @NotEmpty(message = "Campo DESCRIÇÃO é obrigatório")
    @Length(min = 3, max = 200, message = "O campo DESCRIÇÃO deverá ter entre 3 a 200 caracteres")
    private String description;

}
