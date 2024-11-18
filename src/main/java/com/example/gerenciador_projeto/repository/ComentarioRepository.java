package com.example.gerenciador_projeto.repository;

import com.example.gerenciador_projeto.entities.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentarioRepository extends JpaRepository <Comentario, Long> {



   // select * from comentario where id_tarefa = (id tarefa)
   List<Comentario> findComentariosByIdTarefa(Long idTarefa);

}
