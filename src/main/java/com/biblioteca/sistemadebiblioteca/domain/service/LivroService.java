package com.biblioteca.sistemadebiblioteca.domain.service;

import com.biblioteca.sistemadebiblioteca.config.infra.exceptions.livroException.LivroNotFoundException;
import com.biblioteca.sistemadebiblioteca.domain.Enums.LivroEnum;
import com.biblioteca.sistemadebiblioteca.domain.dto.LivroDTO;
import com.biblioteca.sistemadebiblioteca.config.infra.exceptions.livroException.LivroExistsException;
import com.biblioteca.sistemadebiblioteca.domain.service.serviceImpl.LivroServiceImpl;
import com.biblioteca.sistemadebiblioteca.domain.model.Livro;
import com.biblioteca.sistemadebiblioteca.repository.LivroRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService implements LivroServiceImpl {
    private LivroRepository repository;
    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    @Override
    public Livro createBook(LivroDTO livroDTO) throws LivroExistsException {
        if (repository.existsLivroByTitulo(livroDTO.titulo())) {
            throw new LivroExistsException();
        }
        Livro newBook = new Livro(livroDTO.titulo(), livroDTO.categoria());
        return repository.save(newBook);
    }
    @Override
    public List<Livro> getAllBooks() {
        return repository.findAll();
    }
    @Override
    @Transactional
    public boolean deleteBook(int id_book) throws LivroExistsException {
        Livro livro_id = (repository.findById(id_book)
                .orElseThrow(LivroNotFoundException::new));

        repository.deleteById(id_book);
        return true;
    }
    public Livro updateStatusBook(int id) {
        Livro livro = repository.findById(id)
                .orElseThrow(LivroNotFoundException::new);

        if (livro.getStatus() != LivroEnum.EMPRESTADO) {
            livro.setStatus(LivroEnum.EMPRESTADO);
        } else{
            livro.setStatus(LivroEnum.DISPONIVEL);
        }
        return repository.save(livro);
    }
}
