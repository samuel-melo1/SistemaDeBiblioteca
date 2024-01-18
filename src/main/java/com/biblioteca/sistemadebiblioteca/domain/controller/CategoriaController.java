package com.biblioteca.sistemadebiblioteca.domain.controller;

import com.biblioteca.sistemadebiblioteca.domain.dto.CategoriaDTO;
import com.biblioteca.sistemadebiblioteca.domain.model.Categoria;
import com.biblioteca.sistemadebiblioteca.domain.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categoria")
public class CategoriaController {

    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping("/createCategoria")
    public ResponseEntity<Categoria> create(@RequestBody @Valid CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaService.create(categoriaDTO);
        return ResponseEntity.ok(categoria);
    }

    @GetMapping("/getCategorias")
    public ResponseEntity<List<Categoria>> getCategorias() {
        List<Categoria> listCategoria = categoriaService.getCategorias();
        return ResponseEntity.ok(listCategoria);
    }
}
