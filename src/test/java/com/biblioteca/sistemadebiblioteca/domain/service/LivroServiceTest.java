package com.biblioteca.sistemadebiblioteca.domain.service;

import com.biblioteca.sistemadebiblioteca.config.infra.exceptions.livroException.LivroExistsException;
import com.biblioteca.sistemadebiblioteca.config.infra.exceptions.livroException.LivroNotFoundException;
import com.biblioteca.sistemadebiblioteca.domain.Enums.LivroEnum;
import com.biblioteca.sistemadebiblioteca.domain.Enums.PessoaRole;
import com.biblioteca.sistemadebiblioteca.domain.dto.LivroDTO;
import com.biblioteca.sistemadebiblioteca.domain.model.Categoria;
import com.biblioteca.sistemadebiblioteca.domain.model.Emprestimo;
import com.biblioteca.sistemadebiblioteca.domain.model.Livro;
import com.biblioteca.sistemadebiblioteca.domain.model.Pessoa;
import com.biblioteca.sistemadebiblioteca.repository.LivroRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class LivroServiceTest {

    @Mock
    private LivroRepository repository;

    @InjectMocks
    private LivroService livroService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Should successfully register a new books")
    void createBookWhenExceptionFalse() {
        LivroDTO livroDTO = new LivroDTO("Percy Jackson", new Categoria("Romance", "Narrativas centradas em relacionamentos amorosos"));

        Mockito.when(repository.existsLivroByTitulo(livroDTO.titulo())).thenReturn(false);
        LivroDTO newLivro = new LivroDTO(livroDTO.titulo(), livroDTO.categoria());
        this.livroService.createBook(newLivro);

        verify(repository, times(1)).save(any());

    }

    @Test
    @DisplayName("Should throw Exception when book is exist")
    void createBookWhenExceptionTrue() {
        LivroDTO livroDTO = new LivroDTO("Percy Jackson", new Categoria("Romance", "Narrativas centradas em relacionamentos amorosos"));

        Mockito.when(repository.existsLivroByTitulo(livroDTO.titulo())).thenReturn(true);

        Exception thrown = Assertions.assertThrows(LivroExistsException.class, () -> {
            LivroDTO newLivro = new LivroDTO(livroDTO.titulo(), livroDTO.categoria());
            this.livroService.createBook(newLivro);
        });

        Assertions.assertEquals("Livro já cadastrado!", thrown.getMessage());
    }

    @Test
    @DisplayName("Should successfully delete a book")
    void deleteBookWhenFoundedBook() {

        List<Emprestimo> listEmprestimo = new ArrayList<>();
        Livro livro = new Livro(2, "Percy Jackson", listEmprestimo,
                new Categoria("Romance", "Narrativas centradas em relacionamentos amorosos"), LivroEnum.DISPONIVEL);

        Emprestimo emprestimo = new Emprestimo(LocalDate.now(), LocalDate.now().plusDays(7),
                new Pessoa(2, "Samuel", "12254423112", LocalDate.of(2004, 12, 20),
                        "Criciúma",
                        "samuel@gmail.com",
                        "senha123",
                        PessoaRole.ADMIN
                ), livro);
        listEmprestimo.add(emprestimo);

        when(repository.findById(2)).thenReturn(Optional.of(livro));
        boolean result = this.livroService.deleteBook(livro.getId_livro());

        verify(repository, times(1)).deleteById(any());
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Should Exception when delete a book")
    void deleteBookWhenNotFoundBook(){
        when(repository.findById(2)).thenReturn(Optional.empty());

        Exception thrown = Assertions.assertThrows(LivroNotFoundException.class, () -> {
            boolean result = this.livroService.deleteBook(2);
        });
        Assertions.assertEquals("Livro não encontrado!", thrown.getMessage());
    }
}