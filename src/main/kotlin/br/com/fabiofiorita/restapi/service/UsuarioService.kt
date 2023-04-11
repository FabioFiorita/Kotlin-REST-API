package br.com.fabiofiorita.restapi.service

import br.com.fabiofiorita.restapi.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService(var usuarios: List<Usuario>) {
    init {
        val usuario = Usuario(
            id = 1,
            nome = "Joao",
            email = "joao@email.com"
        )
        usuarios = Arrays.asList(usuario)
    }

    fun buscarPorId(id: Long): Usuario {
        return usuarios.stream().filter { c -> c.id == id }.findFirst().get()
    }
}
