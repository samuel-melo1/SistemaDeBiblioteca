package com.biblioteca.sistemadebiblioteca.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_categoria;

    private String nome;
    private String descricao;

    @OneToMany(mappedBy = "categoria")
    private List<Livro> livro;

}
