package com.example.gerenciador_projeto.repository;

import com.example.gerenciador_projeto.entities.Comentario;
import com.example.gerenciador_projeto.entities.Tarefa;
import com.example.gerenciador_projeto.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {


   // select * from comentario where id_tarefa = (id tarefa)
   List<Comentario> findComentariosByTarefa(Tarefa tarefa);

   // select * from comentario
   // join tarefa on comentario.id_tarefa = tarefa.id
   // join projeto on projeto.id = tarefa.projeto_id
   // where projeto.id_usuario = (id usuario) and comentario.id = (id comentario)
   Comentario findByIdAndTarefaProjetoUsuario(Long comentarioId, Usuario usuario);
}
