package com.biblioteca.sistemadebiblioteca.config.exceptions.livroException;

public class LivroNotFoundException extends RuntimeException{

    public LivroNotFoundException(String message){
        super(message);
    }

    public LivroNotFoundException(){
        super("Livro em questão não está em disponivel!");
    }
}
