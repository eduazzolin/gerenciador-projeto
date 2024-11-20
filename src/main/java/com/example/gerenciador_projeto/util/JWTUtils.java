package com.example.gerenciador_projeto.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class JWTUtils {

   private static String SECRET_KEY;
   @Value("${jwt.chave-assinatura}")
   private String secretKey;

   public static Long getUserId(String token) {
      Claims claims = Jwts.parser()
              .setSigningKey(SECRET_KEY.getBytes())
              .parseClaimsJws(token)
              .getBody();
      Number idNumber = claims.get("id", Number.class);
      return idNumber.longValue();
   }

   @PostConstruct
   public void init() {
      SECRET_KEY = this.secretKey;
   }
}
