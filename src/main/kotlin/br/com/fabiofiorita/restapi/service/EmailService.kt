package br.com.fabiofiorita.restapi.service

import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class EmailService(
    private val javaMailSender: JavaMailSender
) {
    fun notificar(emailAutor: String) {
        val message = SimpleMailMessage()
        message.setSubject("Resposta Recebida")
        message.setText("O seu tópico recebeu uma resposta")
        message.setTo(emailAutor)

        javaMailSender.send(message)
    }
}