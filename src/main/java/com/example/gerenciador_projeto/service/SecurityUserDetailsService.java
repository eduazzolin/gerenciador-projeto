package com.example.gerenciador_projeto.service;

import com.example.gerenciador_projeto.entities.Usuario;
import com.example.gerenciador_projeto.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

   private final UsuarioRepository usuarioRepository;

   public SecurityUserDetailsService(UsuarioRepository usuarioRepository) {
      this.usuarioRepository = usuarioRepository;
   }

   @Override
   public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
      Usuario usuarioEncontrado = usuarioRepository.findByEmail(email)
              .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

      return User.builder()
              .username(usuarioEncontrado.getEmail())
              .password(usuarioEncontrado.getSenha())
              .roles("USER")
              .build();
   }
}
