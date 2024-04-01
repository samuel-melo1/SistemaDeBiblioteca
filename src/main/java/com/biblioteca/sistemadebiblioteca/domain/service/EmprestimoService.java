package com.biblioteca.sistemadebiblioteca.domain.service;


import com.biblioteca.sistemadebiblioteca.config.infra.exceptions.livroException.LivroEmprestadoException;
import com.biblioteca.sistemadebiblioteca.microservice.config.producers.EmprestimoProducer;
import com.biblioteca.sistemadebiblioteca.domain.Enums.LivroEnum;
import com.biblioteca.sistemadebiblioteca.domain.model.Emprestimo;
import com.biblioteca.sistemadebiblioteca.domain.model.Livro;
import com.biblioteca.sistemadebiblioteca.repository.EmprestimoRepository;
import com.biblioteca.sistemadebiblioteca.repository.LivroRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class EmprestimoService  {

    private EmprestimoRepository repository;
    private LivroService livroService;
    private LivroRepository livroRepository;
    private EmprestimoProducer emprestimoProducer;

    public EmprestimoService(EmprestimoRepository repository, LivroRepository livroRepository, EmprestimoProducer emprestimoProducer, LivroService livroService) {
        this.repository = repository;
        this.livroRepository = livroRepository;
        this.emprestimoProducer = emprestimoProducer;
        this.livroService = livroService;
    }

    @Transactional
    public Emprestimo emprestar(Emprestimo emprestimo) {
        Livro livro = livroRepository.findLivroByTitulo(emprestimo.getLivro().getTitulo());
        if (livro.getStatus() == LivroEnum.EMPRESTADO) {
            throw new LivroEmprestadoException();
        }
        var newEmprestimo = Emprestimo.builder()
                .data_emprestimo(LocalDate.now())
                .prazo(LocalDate.now().plusDays(7))
                .pessoa(emprestimo.getPessoa())
                .livro(livro).build();

        livroService.updateStatusBook(livro.getId_livro());
        emprestimoProducer.publishedMessageEmail(newEmprestimo);
        return repository.save(newEmprestimo);
    }
}
