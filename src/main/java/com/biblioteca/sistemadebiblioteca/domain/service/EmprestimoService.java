package com.biblioteca.sistemadebiblioteca.domain.service;


import com.biblioteca.sistemadebiblioteca.configuration.rabbitProducer.configs.producers.EmprestimoProducer;
import com.biblioteca.sistemadebiblioteca.domain.model.Enums.LivroEnum;
import com.biblioteca.sistemadebiblioteca.domain.model.domain.Emprestimo;
import com.biblioteca.sistemadebiblioteca.domain.model.domain.Livro;
import com.biblioteca.sistemadebiblioteca.infrastructure.adapters.exceptions.LivroException;
import com.biblioteca.sistemadebiblioteca.domain.model.repository.EmprestimoRepository;
import com.biblioteca.sistemadebiblioteca.domain.model.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class EmprestimoService {

    private EmprestimoRepository repository;
    private LivroService service;
    private LivroRepository livroRepository;
    private EmprestimoProducer emprestimoProducer;

    public EmprestimoService(EmprestimoRepository repository, LivroRepository livroRepository, EmprestimoProducer emprestimoProducer) {
        this.repository = repository;
        this.livroRepository = livroRepository;
        this.emprestimoProducer = emprestimoProducer;
    }

    public Emprestimo emprestar(Emprestimo emprestimo) {
        Livro livro = livroRepository.findLivroByTitulo(emprestimo.getLivro().getTitulo());
        if (livro.getStatus() == LivroEnum.EMPRESTADO) {
            throw new LivroException("Livro Já está emprestado!");
        }
        Emprestimo newEmprestimo = new Emprestimo(LocalDate.now(), LocalDate.now().plusDays(7), emprestimo.getPessoa(), livro);
        livro.setStatus(LivroEnum.EMPRESTADO);
        livroRepository.save(livro);
        emprestimoProducer.publishedMessageEmail(newEmprestimo);
        return repository.save(newEmprestimo);
    }


}
