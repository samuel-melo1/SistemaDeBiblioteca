package com.biblioteca.sistemadebiblioteca.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_emprestimo;

    private LocalDate data_emprestimo;
    private LocalDate prazo;
    @ManyToOne
    private Pessoa pessoa;

    @ManyToOne
    private Livro livro;

}
