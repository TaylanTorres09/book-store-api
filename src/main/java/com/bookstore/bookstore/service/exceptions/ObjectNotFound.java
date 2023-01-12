package com.bookstore.bookstore.service.exceptions;

public class ObjectNotFound extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ObjectNotFound(String arg0) {
        super(arg0);
    }

    public ObjectNotFound(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }
    
}
