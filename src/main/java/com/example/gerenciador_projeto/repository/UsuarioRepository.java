package com.example.gerenciador_projeto.repository;

import com.example.gerenciador_projeto.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository <Usuario, Long> {
}
