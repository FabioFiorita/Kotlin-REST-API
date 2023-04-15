package br.com.fabiofiorita.restapi.model

class CursoTest {
    companion object {
        fun build(): Curso {
            return Curso(
                id = 1,
                nome = "Curso",
                categoria = "Categoria"
            )
        }
    }
}
