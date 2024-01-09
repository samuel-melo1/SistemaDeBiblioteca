package com.biblioteca.sistemadebiblioteca.configuration.rabbitProducer.configs.producers;

import com.biblioteca.sistemadebiblioteca.domain.model.domain.Emprestimo;
import com.biblioteca.sistemadebiblioteca.domain.model.dto.EmailDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmprestimoProducer {

    private RabbitTemplate rabbitTemplate;

    public EmprestimoProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${broker.queue.email.name}")
    private String routingKey;

    public void publishedMessageEmail(Emprestimo emprestimo){
        var emailDto = new EmailDTO();
        emailDto.setUserId(emprestimo.getPessoa().getId_pessoa());
        emailDto.setEmailTo(emprestimo.getPessoa().getEmail());
        emailDto.setSubject(" Empréstimo Confirmado - " + emprestimo.getLivro().getTitulo());
        emailDto.setText("Prezado(a) " + emprestimo.getPessoa().getNome() +
                ", \nConfirmamos o empréstimo do livro " + emprestimo.getLivro().getTitulo() +
                " realizado por você. Por favor, lembre-se de devolvê-lo até " + emprestimo.getPrazo() +
                " para evitar atrasos.\n" +
                "\n");

        rabbitTemplate.convertAndSend("", routingKey, emailDto);


    }
}
