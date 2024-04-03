package com.biblioteca.sistemadebiblioteca.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Emprestimo implements Serializable {

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
