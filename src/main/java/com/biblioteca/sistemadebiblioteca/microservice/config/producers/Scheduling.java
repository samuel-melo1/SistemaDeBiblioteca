package com.biblioteca.sistemadebiblioteca.microservice.config.producers;

import com.biblioteca.sistemadebiblioteca.config.infra.exceptions.pessoaException.PessoaNotFoundException;
import com.biblioteca.sistemadebiblioteca.domain.dto.EmailDTO;
import com.biblioteca.sistemadebiblioteca.domain.model.Emprestimo;
import com.biblioteca.sistemadebiblioteca.repository.EmprestimoRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Service
@Slf4j
public class Scheduling {


    private EmprestimoRepository emprestimoRepository;
    private RabbitTemplate rabbitTemplate;
    public Scheduling(EmprestimoRepository emprestimoRepository, RabbitTemplate rabbitTemplate){
        this.emprestimoRepository = emprestimoRepository;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${broker.queue.email.name}")
    private String routingKey;

    @Scheduled(cron = "0 0 6")
    public void verifyDeadline(){
        List<Emprestimo> listEmprestimo = emprestimoRepository.buscarEmprestimo();

        for (Emprestimo emprestimo : listEmprestimo) {
           if(emprestimo.getPrazo().minusDays(1).isEqual(LocalDate.now())){
                var emailDto = new EmailDTO();
                emailDto.setUserId(emprestimo.getPessoa().getId_pessoa());
                emailDto.setEmailTo(emprestimo.getPessoa().getEmail());
                emailDto.setSubject("Lembrete: Devolução de Livro em Breve - " + emprestimo.getLivro().getTitulo());
                emailDto.setText("Prezado(a) " + emprestimo.getPessoa().getNome() +
                        ",\n\nEste é um lembrete amigável de que o livro que você pegou emprestado, intitulado \"" +
                        emprestimo.getLivro().getTitulo() + "\", está prestes a vencer. Pedimos a gentileza de devolvê-lo até a data de vencimento para evitar possíveis penalidades.\n\n" +
                        "Detalhes do Empréstimo:\n" +
                        "- Título do Livro: " + emprestimo.getLivro().getTitulo() + "\n" +
                        "- Data de Empréstimo: " + emprestimo.getData_emprestimo() + "\n" +
                        "- Data de Vencimento: " + emprestimo.getPrazo() + "\n\n" +
                        "Agradecemos pela sua atenção e cooperação.");

                rabbitTemplate.convertAndSend("", routingKey, emailDto);
           }
        }
    }
}
