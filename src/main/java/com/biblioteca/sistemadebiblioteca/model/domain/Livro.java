package com.biblioteca.sistemadebiblioteca.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_livro;

    private String titulo;
    @OneToMany(mappedBy = "livro")
    private List<Emprestimo> emprestimo;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    public Livro(String titulo, Categoria categoria){
        this.titulo = titulo;
        this.categoria = categoria;

    }

}
