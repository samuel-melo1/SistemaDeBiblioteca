package com.biblioteca.sistemadebiblioteca.domain.service;

import com.biblioteca.sistemadebiblioteca.config.infra.exceptions.livroException.LivroEmprestadoException;
import com.biblioteca.sistemadebiblioteca.domain.Enums.LivroEnum;
import com.biblioteca.sistemadebiblioteca.domain.Enums.PessoaRole;
import com.biblioteca.sistemadebiblioteca.domain.model.Categoria;
import com.biblioteca.sistemadebiblioteca.domain.model.Emprestimo;
import com.biblioteca.sistemadebiblioteca.domain.model.Livro;
import com.biblioteca.sistemadebiblioteca.domain.model.Pessoa;
import com.biblioteca.sistemadebiblioteca.repository.EmprestimoRepository;
import com.biblioteca.sistemadebiblioteca.repository.LivroRepository;
import com.biblioteca.sistemadebiblioteca.microservice.config.producers.EmprestimoProducer;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class EmprestimoServiceTest {

    @Mock
    private EmprestimoRepository repository;
    @Mock
    private LivroService service;
    @Mock
    private LivroRepository livroRepository;
    @Mock
    private EmprestimoProducer emprestimoProducer;
    @InjectMocks
    private EmprestimoService emprestimoService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Should successfully borrow a book")
    void borrowABookWhenExceptionFalse() {
        List<Emprestimo> listEmprestimo = new ArrayList<>();
        Livro livro = new Livro(2, "Percy Jackson", listEmprestimo,
                new Categoria("Romance", "Narrativas centradas em relacionamentos amorosos"), LivroEnum.DISPONIVEL);

        Mockito.when(livroRepository.findLivroByTitulo(livro.getTitulo())).thenReturn(livro);

        Emprestimo emprestimo = new Emprestimo(LocalDate.now(), LocalDate.now().plusDays(7),
                new Pessoa(2, "Samuel", "12256131912", LocalDate.of(2004, 12, 20),
                        "Criciúma",
                        "samuel@gmail.com",
                        "senha123",
                        PessoaRole.ADMIN
                ), livro);

        emprestimoService.emprestar(emprestimo);

        verify(livroRepository, times(1)).save(any());
        verify(emprestimoProducer, times(1)).publishedMessageEmail(Mockito.any());
        assertEquals(livro.getStatus(), LivroEnum.EMPRESTADO);

    }

    @Test
    @DisplayName("Should Exception when borrow a book")
    void borrowABookWhenExceptionTrue() {

        List<Emprestimo> listEmprestimo = new ArrayList<>();
        Livro livro = new Livro(2, "Percy Jackson", listEmprestimo,
                new Categoria("Romance", "Narrativas centradas em relacionamentos amorosos"), LivroEnum.EMPRESTADO);

        Mockito.when(livroRepository.findLivroByTitulo(livro.getTitulo())).thenReturn(livro);

        Exception thrown = Assertions.assertThrows(LivroEmprestadoException.class, () -> {
            Emprestimo emprestimo = new Emprestimo(LocalDate.now(), LocalDate.now().plusDays(7),
                    new Pessoa(2, "Samuel", "12256131912", LocalDate.of(2004, 12, 20),
                            "Criciúma",
                            "samuel@gmail.com",
                            "senha123",
                            PessoaRole.ADMIN
                    ), livro);

            emprestimoService.emprestar(emprestimo);
        });

        Assertions.assertEquals("Livro está emprestado!", thrown.getMessage());
        assertEquals(livro.getStatus(), LivroEnum.EMPRESTADO);

    }
}