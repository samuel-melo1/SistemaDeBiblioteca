package com.biblioteca.sistemadebiblioteca.domain.interfaces;

import com.biblioteca.sistemadebiblioteca.domain.dto.LivroDTO;
import com.biblioteca.sistemadebiblioteca.domain.model.Livro;

import java.util.List;

public interface LivroServiceImpl {

    public Livro createBook(LivroDTO livroDTO);

    public List<Livro> getAllBooks();

    public boolean deleteBook(int id_book);
}
