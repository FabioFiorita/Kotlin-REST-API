package br.com.fabiofiorita.restapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@EnableCaching
@SpringBootApplication
class RestapiApplication

fun main(args: Array<String>) {
	runApplication<RestapiApplication>(*args)
}
