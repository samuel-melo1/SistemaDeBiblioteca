package com.biblioteca.sistemadebiblioteca.controller.domainController;

import com.biblioteca.sistemadebiblioteca.model.dto.CategoriaDTO;
import com.biblioteca.sistemadebiblioteca.model.domain.Categoria;
import com.biblioteca.sistemadebiblioteca.model.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }

    @PostMapping("/createCategoria")
    public ResponseEntity<Categoria> create(@RequestBody @Valid CategoriaDTO categoriaDTO){
       Categoria categoria = categoriaService.create(categoriaDTO);
        return ResponseEntity.ok(categoria);

    }
}
