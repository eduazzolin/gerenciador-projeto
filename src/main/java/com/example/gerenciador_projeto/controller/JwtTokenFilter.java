package com.example.gerenciador_projeto.controller;

import com.example.gerenciador_projeto.repository.JwtRepository;
import com.example.gerenciador_projeto.service.SecurityUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtTokenFilter extends OncePerRequestFilter {

   private final JwtRepository jwtRepository;
   private final SecurityUserDetailsService userDetailsService;

   public JwtTokenFilter(JwtRepository jwtRepository, SecurityUserDetailsService userDetailsService) {
      this.jwtRepository = jwtRepository;
      this.userDetailsService = userDetailsService;
   }

   @Override
   protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
      String authorization = request.getHeader("Authorization");

      if (authorization != null && authorization.startsWith("Bearer")) {
         String token = authorization.substring(7);
         boolean isValid = jwtRepository.isTokenValido(token);

         if (isValid) {
            String username = jwtRepository.obterLoginUsuario(token);
            UserDetails usuarioAutenticado = userDetailsService.loadUserByUsername(username);
            UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(
                    usuarioAutenticado,
                    null,
                    usuarioAutenticado.getAuthorities());
            user.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(user);
         }
      }
      filterChain.doFilter(request, response);


   }
}
