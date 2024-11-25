package com.example.gerenciador_projeto.service;

import com.example.gerenciador_projeto.entities.Usuario;
import com.example.gerenciador_projeto.repository.JwtRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
public class JwtService implements JwtRepository {

   @Value("${JWT_EXPIRACAO}")
   private String expiracao;

   @Value("${JWT_CHAVE_ASSINATURA}")
   private String chaveAssinatura;


   @Override
   public String generateToken(Usuario usuario) {
      long exp = Long.parseLong(expiracao);
      LocalDateTime dataExp = LocalDateTime.now().plusMinutes(exp);
      Instant instant = dataExp.atZone(ZoneId.systemDefault()).toInstant();
      SecretKey key = Keys.hmacShaKeyFor(chaveAssinatura.getBytes(StandardCharsets.UTF_8));

      return Jwts.builder()
              .setSubject(usuario.getEmail())
              .claim("id", usuario.getId())
              .claim("nome", usuario.getNome())
              .claim("hora-expiracao", dataExp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
              .setExpiration(Date.from(instant))
              .signWith(key, SignatureAlgorithm.HS512)
              .compact();
   }

   @Override
   public Claims obterClaims(String token) throws ExpiredJwtException {
      SecretKey key = Keys.hmacShaKeyFor(chaveAssinatura.getBytes(StandardCharsets.UTF_8));
      return Jwts.parserBuilder()
              .setSigningKey(key)
              .build()
              .parseClaimsJws(token)
              .getBody();
   }

   @Override
   public boolean isTokenValido(String token) {
      try {
         Claims claims = obterClaims(token);
         Date dataExpiracao = claims.getExpiration();
         LocalDateTime data = dataExpiracao.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
         return LocalDateTime.now().isBefore(data);
      } catch (Exception e) {
         return false;
      }
   }

   @Override
   public String obterLoginUsuario(String token) {
      Claims claims = obterClaims(token);
      return claims.getSubject();
   }
}
