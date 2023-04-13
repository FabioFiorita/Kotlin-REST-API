package br.com.fabiofiorita.restapi.repository

import br.com.fabiofiorita.restapi.model.Topico
import org.springframework.data.jpa.repository.JpaRepository

interface TopicoRepository: JpaRepository<Topico, Long> {
}