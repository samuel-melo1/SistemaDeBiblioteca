package com.biblioteca.sistemadebiblioteca.config.security;

import com.biblioteca.sistemadebiblioteca.config.token.SecurityFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private SecurityFilter securityFilter;
    SecurityConfig(SecurityFilter securityFilter){
        this.securityFilter = securityFilter;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/api/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST,"/api/v1/register").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"api/v1/listUsers").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "api/v1/deleteUsers/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST,"api/v1/book/createBook").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "api/v1/book/deleteBook/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST,"/api/v1/createCategoria").hasRole("ADMIN")
                        .requestMatchers(AUTH_WHITELIST).permitAll()
                        .anyRequest().authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();

    }
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    public static final String[] AUTH_WHITELIST = {
        "/api/v1/auth/**",
        "/v3/api-docs/**",
        "/v3/api-docs.yaml",
        "/swagger-ui.html",
        "/swagger-ui/**"

    };

}
