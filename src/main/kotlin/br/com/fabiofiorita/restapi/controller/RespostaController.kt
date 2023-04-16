package br.com.fabiofiorita.restapi.controller

import br.com.fabiofiorita.restapi.model.Resposta
import br.com.fabiofiorita.restapi.service.RespostaService
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("/respostas")
class RespostaController(
    private val respostaService: RespostaService
) {
    @PostMapping
    fun salvar(@RequestBody @Valid resposta: Resposta) = respostaService.salvar(resposta)
}