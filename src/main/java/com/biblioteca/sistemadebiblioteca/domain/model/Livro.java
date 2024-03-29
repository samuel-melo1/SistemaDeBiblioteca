package com.biblioteca.sistemadebiblioteca.domain.model;

import com.biblioteca.sistemadebiblioteca.domain.Enums.LivroEnum;
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
    @JsonIgnore
    @OneToMany(mappedBy = "livro", cascade = CascadeType.ALL)
    private List<Emprestimo> emprestimo;
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
    @JsonIgnore
    private LivroEnum status;
    public Livro(String titulo, Categoria categoria){
        this.titulo = titulo;
        this.categoria = categoria;
    }
}
