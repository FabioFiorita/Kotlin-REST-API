package br.com.fabiofiorita.restapi.service

import br.com.fabiofiorita.restapi.exception.NotFoundException
import br.com.fabiofiorita.restapi.model.Usuario
import br.com.fabiofiorita.restapi.repository.UsuarioRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UsuarioService(private val repository: UsuarioRepository, private val notFoundMessage: String = "Usuario não encontrado!") {
    fun buscarPorId(id: Long): Usuario {
        return repository.findByIdOrNull(id) ?: throw NotFoundException(notFoundMessage)
    }
}
