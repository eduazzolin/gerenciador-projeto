package com.example.gerenciador_projeto.repository;

import com.example.gerenciador_projeto.entities.Comentario;
import com.example.gerenciador_projeto.entities.Projeto;
import com.example.gerenciador_projeto.entities.Tarefa;
import com.example.gerenciador_projeto.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {


   // select * from tarefa inner join projeto on tarefa.id_projeto = projeto.id where tarefa.id = (id tarefa) and projeto.id_usuario = (id usuario)
   Optional<Tarefa> findByIdAndProjetoUsuarioId(Long tarefaId, Long usuarioId);

   // select * from tarefa inner join projeto on tarefa.id_projeto = projeto.id where projeto.id_usuario = (id usuario)
   List<Tarefa> findByProjetoUsuarioId(Long usuarioId);

   List<Tarefa> findByProjetoUsuarioIdAndProjetoId(Long usuarioId, Long projetoId);


}
