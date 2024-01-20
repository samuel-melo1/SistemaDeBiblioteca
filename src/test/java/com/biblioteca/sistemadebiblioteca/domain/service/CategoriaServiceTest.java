package com.biblioteca.sistemadebiblioteca.domain.service;

import com.biblioteca.sistemadebiblioteca.config.infra.exceptions.categoriaException.CategoriaExistException;
import com.biblioteca.sistemadebiblioteca.domain.dto.CategoriaDTO;
import com.biblioteca.sistemadebiblioteca.repository.CategoriaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CategoriaServiceTest {

    @Mock
    private CategoriaRepository categoriaRepository;

    @InjectMocks
    CategoriaService categoriaService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Should successfully register a new categoria")
    void createCategoriaWhenExceptionFalse() {

        CategoriaDTO categoriaDTO = new CategoriaDTO("Romance", "Narrativas centradas em relacionamentos amorosos");

        Mockito.when(categoriaRepository.existsCategoriaByNome(categoriaDTO.nome())).thenReturn(false);
        this.categoriaService.create(categoriaDTO);

        verify(categoriaRepository, times(1)).save(any());
    }

    @Test
    @DisplayName("Should Exception when register a new categoria")
    void createCategoriaWhenExceptionTrue(){

        CategoriaDTO categoriaDTO = new CategoriaDTO("Romance", "Narrativas centradas em relacionamentos amorosos");

        Mockito.when(categoriaRepository.existsCategoriaByNome(categoriaDTO.nome())).thenReturn(true);

        Exception thrown = Assertions.assertThrows(CategoriaExistException.class, () -> {
            this.categoriaService.create(categoriaDTO);
        });

        Assertions.assertEquals("Categoria já existe!", thrown.getMessage());
    }


}