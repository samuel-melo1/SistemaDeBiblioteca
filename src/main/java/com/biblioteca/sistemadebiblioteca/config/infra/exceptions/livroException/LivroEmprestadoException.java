package com.biblioteca.sistemadebiblioteca.config.infra.exceptions.livroException;

public class LivroEmprestadoException extends  RuntimeException {

    public LivroEmprestadoException(){
        super("Livro está emprestado!");
    }
}
