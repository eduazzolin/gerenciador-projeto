package com.example.gerenciador_projeto.repository;

import com.example.gerenciador_projeto.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository <Usuario, Long> {

   boolean existsByEmail(String email);
   Optional<Usuario> findByEmail(String email);


}
