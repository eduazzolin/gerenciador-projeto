package com.example.gerenciador_projeto.repository;

import com.example.gerenciador_projeto.entities.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
