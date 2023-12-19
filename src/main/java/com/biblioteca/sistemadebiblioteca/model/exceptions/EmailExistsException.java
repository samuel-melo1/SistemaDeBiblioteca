package com.biblioteca.sistemadebiblioteca.model.exceptions;

public class EmailExistsException extends  RuntimeException {

    public EmailExistsException(String message){
        super(message);
    }
}
