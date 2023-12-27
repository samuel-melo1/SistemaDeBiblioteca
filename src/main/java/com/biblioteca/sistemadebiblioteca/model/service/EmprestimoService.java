package com.biblioteca.sistemadebiblioteca.model.service;


import com.biblioteca.sistemadebiblioteca.model.Enums.LivroEnum;
import com.biblioteca.sistemadebiblioteca.model.domain.Emprestimo;
import com.biblioteca.sistemadebiblioteca.model.domain.Livro;
import com.biblioteca.sistemadebiblioteca.model.domain.Pessoa;
import com.biblioteca.sistemadebiblioteca.model.dto.EmprestimoDTO;
import com.biblioteca.sistemadebiblioteca.model.exceptions.LivroException;
import com.biblioteca.sistemadebiblioteca.model.repository.EmprestimoRepository;
import com.biblioteca.sistemadebiblioteca.model.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class EmprestimoService {

    private EmprestimoRepository repository;
    private LivroService service;
    private LivroRepository livroRepository;

    public EmprestimoService(EmprestimoRepository repository, LivroRepository livroRepository) {
        this.repository = repository;
        this.livroRepository = livroRepository;
    }

    public Emprestimo emprestar(Emprestimo emprestimo) {
        Livro livro = livroRepository.findLivroByTitulo(emprestimo.getLivro().getTitulo());
        if (livro.getStatus() == LivroEnum.EMPRESTADO) {
            throw new LivroException("Livro Já está emprestado!");
        }
        Emprestimo newEmprestimo = new Emprestimo(LocalDate.now(), LocalDate.now().plusDays(7), emprestimo.getPessoa(), livro);
        livro.setStatus(LivroEnum.EMPRESTADO);
        livroRepository.save(livro);
        return repository.save(newEmprestimo);
    }


}
