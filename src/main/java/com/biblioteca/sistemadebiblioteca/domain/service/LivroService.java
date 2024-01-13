package com.biblioteca.sistemadebiblioteca.domain.service;

import com.biblioteca.sistemadebiblioteca.config.exceptions.livroException.LivroNotFoundException;
import com.biblioteca.sistemadebiblioteca.domain.model.dto.LivroDTO;
import com.biblioteca.sistemadebiblioteca.config.exceptions.livroException.LivroExistsException;
import com.biblioteca.sistemadebiblioteca.domain.model.entity.Livro;
import com.biblioteca.sistemadebiblioteca.config.db.repository.LivroRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    private LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public Livro createBook(LivroDTO livroDTO) throws LivroExistsException {
        if (repository.existsLivroByTitulo(livroDTO.titulo())) {
            throw new LivroExistsException();
        }
        Livro newBook = new Livro(livroDTO.titulo(), livroDTO.categoria());
        return repository.save(newBook);
    }

    public List<Livro> getAllBooks() {
        return repository.findAll();
    }

    @Transactional
    public boolean deleteBook(int id_book) throws LivroExistsException {
        Optional<Livro> livro_id = repository.findById(id_book);
        if (livro_id.isEmpty()) {
            throw new LivroNotFoundException();
        }
        repository.deleteById(id_book);
        return true;
    }

}
