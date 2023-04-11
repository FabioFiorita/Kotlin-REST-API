package br.com.fabiofiorita.restapi.mapper

interface Mapper<T, U> {
    fun map(t: T): U
}
