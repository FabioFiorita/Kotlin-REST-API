package br.com.fabiofiorita.restapi.model

class UsuarioTest {
    companion object {
        fun build(): Usuario {
            return Usuario(
                id = 1,
                nome = "Usuario",
                email = "usuario@email.com",
                password = "123456"
            )
        }
    }
}
