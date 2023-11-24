package com.biblioteca.sistemadebiblioteca.exceptions;

public class EmailExistsException extends  Exception {

    public EmailExistsException(String message){
        super(message);
    }
}
