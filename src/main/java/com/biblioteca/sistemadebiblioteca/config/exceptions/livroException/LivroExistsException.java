package com.biblioteca.sistemadebiblioteca.config.exceptions.livroException;

public class LivroExistsException extends RuntimeException{

    public LivroExistsException(String message){
        super(message);
    }

    public LivroExistsException(){
        super("Livro já cadastrado!");
    }
}
