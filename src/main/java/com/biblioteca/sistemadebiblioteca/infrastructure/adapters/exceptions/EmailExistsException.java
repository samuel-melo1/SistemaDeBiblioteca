package com.biblioteca.sistemadebiblioteca.infrastructure.adapters.exceptions;

public class EmailExistsException extends  RuntimeException {

    public EmailExistsException(String message){
        super(message);
    }
}
