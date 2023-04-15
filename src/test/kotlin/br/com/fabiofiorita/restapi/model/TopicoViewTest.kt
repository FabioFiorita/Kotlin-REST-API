package br.com.fabiofiorita.restapi.model

import br.com.fabiofiorita.restapi.dto.TopicoView
import java.time.LocalDate
import java.time.LocalDateTime

class TopicoViewTest {
    companion object {
        fun build(): TopicoView {
            return TopicoView(
                id = 1,
                titulo = "Titulo",
                mensagem = "Mensagem",
                status = StatusTopico.NAO_RESPONDIDO,
                dataCriacao = LocalDateTime.now(),
                dataAlteracao = LocalDate.now()
            )
        }
    }
}