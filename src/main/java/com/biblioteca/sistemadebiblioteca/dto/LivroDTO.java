package com.biblioteca.sistemadebiblioteca.dto;

import com.biblioteca.sistemadebiblioteca.model.Categoria;
import com.biblioteca.sistemadebiblioteca.model.Emprestimo;

import java.util.List;

public record LivroDTO(Integer id_livro, String titulo, List<Emprestimo> emprestimo, Categoria categoria) {
}
