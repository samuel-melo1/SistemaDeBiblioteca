package com.biblioteca.sistemadebiblioteca.exceptions;

public class LivroExistsException extends RuntimeException{

    public LivroExistsException(String message){
        super(message);
    }
}
