package br.com.fabiofiorita.restapi.config

import br.com.fabiofiorita.restapi.service.UsuarioService
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.stereotype.Component
import java.util.*

@Component
class JWTUtil(
    private val usuarioService: UsuarioService
) {

    private val secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512)
    private val expiration: Long = 300000


    @Value("\${jwt.secret}")
    private lateinit var secret: String

    fun generateToken(username: String, authorities: MutableCollection<out GrantedAuthority>): String? {
        return Jwts.builder()
            .setSubject(username)
            .claim("role", authorities)
            .setIssuedAt(Date(System.currentTimeMillis() + expiration))
            .signWith(secretKey)
            .compact()
    }


    fun isValid(token: String): Boolean {
        return try {
            Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun getAuthentication(token: String): Authentication {
        val username = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).body.subject
        val user = usuarioService.loadUserByUsername(username)
        return UsernamePasswordAuthenticationToken(username, null, user.authorities)
    }
}