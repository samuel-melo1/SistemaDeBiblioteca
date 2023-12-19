package com.biblioteca.sistemadebiblioteca.model.domain;

import com.biblioteca.sistemadebiblioteca.model.Enums.LivroEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "id_livro")
    private Livro livro;

    public Emprestimo(LocalDate data_emprestimo, LocalDate prazo, Pessoa pessoa, Livro livro){
        this.data_emprestimo = data_emprestimo;
        this.prazo = prazo;
        this.pessoa = pessoa;
        this.livro = livro;
    }

}
