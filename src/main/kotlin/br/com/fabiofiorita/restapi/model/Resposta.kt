package br.com.fabiofiorita.restapi.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.time.LocalDateTime
@Entity
data class Resposta (
    @Id @GeneratedValue
    val id: Long? = null,
    val mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    val autor: Usuario,
    @ManyToOne
    val topico: Topico,
    val solucao: Boolean
)