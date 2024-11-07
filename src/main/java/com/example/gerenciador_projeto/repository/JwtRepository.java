package com.example.gerenciador_projeto.repository;

import com.example.gerenciador_projeto.entities.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;


public interface JwtRepository {

   String generateToken(Usuario usuario);

   Claims obterClaims(String token) throws ExpiredJwtException;

   boolean isTokenValido(String token);

   String obterLoginUsuario(String token);

}