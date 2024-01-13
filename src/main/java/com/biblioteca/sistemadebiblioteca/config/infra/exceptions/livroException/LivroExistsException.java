package com.biblioteca.sistemadebiblioteca.config.infra.exceptions.livroException;

public class LivroExistsException extends RuntimeException{

    public LivroExistsException(String message){
        super(message);
    }

    public LivroExistsException(){
        super("Livro já cadastrado!");
    }
}
