package com.biblioteca.sistemadebiblioteca.domain.model;

import com.biblioteca.sistemadebiblioteca.domain.Enums.PessoaRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
public class Pessoa implements UserDetails, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_pessoa;

    private String nome;
    private String cpf;
    private String endereco;
    private LocalDate data_nascimento;
    private String email;
    private String senha;
    private PessoaRole role;

    @JsonIgnore
    @OneToMany(mappedBy = "pessoa")
    private List<Emprestimo> emprestimo;

    public Pessoa(String nome,String cpf,LocalDate data_nascimento, String endereco, String email,  String senha,PessoaRole role){
        this.role = role;
        this.nome = nome;
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;
        this.endereco = endereco;
        this.senha = senha;
        this.email = email;
    }
    public Pessoa(){

    }

    public Pessoa(Integer id_pessoa, String nome, String cpf, LocalDate data_nascimento, String endereco,
                  String email, String senha, PessoaRole pessoaRole) {
    }

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == PessoaRole.ADMIN){
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        }
        else{
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }
    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
