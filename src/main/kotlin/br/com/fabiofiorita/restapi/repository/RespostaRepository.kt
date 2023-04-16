package br.com.fabiofiorita.restapi.repository

import br.com.fabiofiorita.restapi.model.Resposta
import org.springframework.data.jpa.repository.JpaRepository

interface RespostaRepository: JpaRepository<Resposta, Long>