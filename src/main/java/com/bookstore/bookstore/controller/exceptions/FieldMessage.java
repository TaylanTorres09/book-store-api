package com.bookstore.bookstore.controller.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FieldMessage {
    
    private String fieldName;
    private String message;

}
