package com.biblioteca.sistemadebiblioteca.config.infra.exceptions.livroException;

public class LivroNotFoundException extends RuntimeException{

    public LivroNotFoundException(String message){
        super(message);
    }

    public LivroNotFoundException(){
        super("Livro não encontrado!");
    }
}
