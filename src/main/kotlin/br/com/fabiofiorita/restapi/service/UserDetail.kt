package br.com.fabiofiorita.restapi.service

import br.com.fabiofiorita.restapi.model.Usuario
import org.springframework.security.core.userdetails.UserDetails

class UserDetail(
    private val usuario: Usuario
): UserDetails {
    override fun getAuthorities() = usuario.roles

    override fun getPassword(): String = usuario.password

    override fun getUsername(): String = usuario.email

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true
}