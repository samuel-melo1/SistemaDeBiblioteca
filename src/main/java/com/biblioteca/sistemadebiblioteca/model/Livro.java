package com.biblioteca.sistemadebiblioteca.model;

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
    @JoinColumn(name="emprestimo_id")
    private List<Emprestimo> emprestimo;
    @ManyToOne
    private Categoria categoria;
}
