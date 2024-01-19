package com.biblioteca.sistemadebiblioteca.service;

import com.biblioteca.sistemadebiblioteca.domain.dto.CategoriaDTO;
import com.biblioteca.sistemadebiblioteca.domain.model.Categoria;
import com.biblioteca.sistemadebiblioteca.domain.repository.CategoriaRepository;
import com.biblioteca.sistemadebiblioteca.domain.service.CategoriaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
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
    void getCategorias() {
    }
}