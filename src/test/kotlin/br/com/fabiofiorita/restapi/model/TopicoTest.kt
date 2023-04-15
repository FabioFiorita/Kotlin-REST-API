package br.com.fabiofiorita.restapi.model

object TopicoTest {
    fun build(): Topico {
        return Topico(
            id = 1,
            titulo = "Titulo",
            mensagem = "Mensagem",
            curso = CursoTest.build(),
            autor = UsuarioTest.build()
        )
    }
}