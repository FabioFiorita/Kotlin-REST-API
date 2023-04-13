package br.com.fabiofiorita.restapi.repository

import br.com.fabiofiorita.restapi.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository: JpaRepository<Usuario, Long> {
}