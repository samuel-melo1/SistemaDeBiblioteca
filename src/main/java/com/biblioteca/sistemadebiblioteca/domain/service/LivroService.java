package com.biblioteca.sistemadebiblioteca.domain.service;

import com.biblioteca.sistemadebiblioteca.config.infra.exceptions.livroException.LivroNotFoundException;
import com.biblioteca.sistemadebiblioteca.domain.Enums.LivroEnum;
import com.biblioteca.sistemadebiblioteca.domain.dto.CategoriaDTO;
import com.biblioteca.sistemadebiblioteca.domain.dto.LivroDTO;
import com.biblioteca.sistemadebiblioteca.config.infra.exceptions.livroException.LivroExistsException;
import com.biblioteca.sistemadebiblioteca.domain.model.Categoria;
import com.biblioteca.sistemadebiblioteca.domain.model.Livro;
import com.biblioteca.sistemadebiblioteca.repository.LivroRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    private LivroRepository repository;
    private CategoriaService categoriaService;

    public LivroService(LivroRepository repository, CategoriaService categoriaService) {
        this.repository = repository;
        this.categoriaService = categoriaService;
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

    public Livro updateStatusBook(Integer id) {
        Livro livro = this.repository.findById(id)
                .orElseThrow(LivroNotFoundException::new);

        if(livro.getStatus() != null) livro.setStatus(LivroEnum.EMPRESTADO);

        this.repository.save(livro);
        return livro;
    }
}
