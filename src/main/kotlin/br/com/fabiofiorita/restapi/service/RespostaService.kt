package br.com.fabiofiorita.restapi.service

import br.com.fabiofiorita.restapi.model.Resposta
import br.com.fabiofiorita.restapi.repository.RespostaRepository
import org.springframework.stereotype.Service

@Service
class RespostaService(
    private val respostaRepository: RespostaRepository,
    private val emailService: EmailService
) {
    fun salvar(resposta: Resposta) {
        respostaRepository.save(resposta)
        val emailAutor = resposta.topico.autor.email
        emailService.notificar(emailAutor = emailAutor)
    }
}