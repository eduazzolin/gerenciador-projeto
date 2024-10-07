package com.example.gerenciador_projeto.repository;

import com.example.gerenciador_projeto.entities.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository <Comentario, Long> {
}
