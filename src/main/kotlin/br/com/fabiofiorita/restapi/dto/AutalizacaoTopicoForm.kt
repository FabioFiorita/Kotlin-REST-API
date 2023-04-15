package br.com.fabiofiorita.restapi.dto

import javax.validation.constraints.NotNull
import javax.validation.constraints.Size
import javax.validation.constraints.NotEmpty

data class AutalizacaoTopicoForm(
    @field:NotNull
    val id: Long,
    @field:NotEmpty
    @field:Size(min = 5, max = 100, message = "Titulo deve ter entre 5 e 100 caracteres")
    val titulo: String,
    @field:NotEmpty
    val mensagem: String,
)
