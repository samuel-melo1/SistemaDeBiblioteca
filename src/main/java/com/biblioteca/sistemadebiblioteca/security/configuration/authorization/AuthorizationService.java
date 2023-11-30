package com.biblioteca.sistemadebiblioteca.security.configuration.authorization;

import com.biblioteca.sistemadebiblioteca.repository.PessoaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService {

    private PessoaRepository pessoaRepository;

    public AuthorizationService(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return pessoaRepository.findByEmail(username);
    }
}
