package com.example.gerenciador_projeto.repository;

import com.example.gerenciador_projeto.entities.HistoricoTarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricoTarefaRepository extends JpaRepository<HistoricoTarefa, Long> {
}
