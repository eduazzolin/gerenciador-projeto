package com.example.gerenciador_projeto.service;

import com.example.gerenciador_projeto.dto.ComentarioDTO;
import com.example.gerenciador_projeto.dto.TarefaDTO;
import com.example.gerenciador_projeto.entities.Comentario;
import com.example.gerenciador_projeto.entities.Projeto;
import com.example.gerenciador_projeto.entities.Tarefa;
import com.example.gerenciador_projeto.entities.Usuario;
import com.example.gerenciador_projeto.repository.ComentarioRepository;
import com.example.gerenciador_projeto.repository.TarefaRepository;
import com.example.gerenciador_projeto.util.TarefaMapper;
import com.example.gerenciador_projeto.util.Validacoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TarefaService {

   @Autowired
   private TarefaRepository tarefaRepository;

   @Autowired
   private ComentarioRepository comentarioRepository;

   @Autowired
   private Validacoes validacoes;

   public TarefaDTO criar(TarefaDTO tarefaDTO, Long userId) {

      tarefaDTO.setDataCriacao(LocalDateTime.now());
      Usuario usuarioRequisicao = new Usuario();
      usuarioRequisicao.setId(userId);

      if (
              !validacoes.validarStatusTarefa(tarefaDTO) ||
                      !validacoes.validarProjetoTarefa(tarefaDTO, usuarioRequisicao)

      ) {
         // throw error
         throw new RuntimeException("Erro ao criar tarefa");
      }

      Tarefa tarefa = TarefaMapper.toEntity(tarefaDTO);
      return TarefaMapper.toDTO(tarefaRepository.save(tarefa));
   }

   public Comentario criarComentario(ComentarioDTO comentarioDTO, Long userId) {
      Usuario usuarioRequisicao = new Usuario();
      usuarioRequisicao.setId(userId);
      Tarefa tarefa = tarefaRepository.findByIdAndProjetoUsuarioId(comentarioDTO.getIdTarefa(), userId)
              .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
      Comentario comentario = new Comentario();
      comentario.setTarefa(tarefa);
      comentario.setDataCriacao(LocalDateTime.now());
      comentario.setComentario(comentarioDTO.getComentario());
      return comentarioRepository.save(comentario);
   }

   public List<Comentario> listarComentarios(Tarefa tarefa) {
      return comentarioRepository.findComentariosByTarefa(tarefa);
   }

   public Tarefa buscarPorId(Long id, Long userId) {
      return tarefaRepository.findByIdAndProjetoUsuarioId(id, userId)
              .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
   }

   public List<TarefaDTO> listarPorUsuario(Usuario usuario) {
      List<Tarefa> tarefas = tarefaRepository.findByProjetoUsuarioId(usuario.getId());
      List<TarefaDTO> tarefasDTO = new ArrayList<>();
      for (Tarefa tarefa : tarefas) {
         tarefasDTO.add(TarefaMapper.toDTO(tarefa));
      }
      return tarefasDTO;
   }

   public List<TarefaDTO> listarPorUsuarioPorProjeto(Usuario usuario, Projeto projeto) {
      List<Tarefa> tarefas = tarefaRepository.findByProjetoUsuarioIdAndProjetoIdAndIsDeletedFalse(usuario.getId(), projeto.getId());
      List<TarefaDTO> tarefasDTO = new ArrayList<>();
      for (Tarefa tarefa : tarefas) {
         tarefasDTO.add(TarefaMapper.toDTO(tarefa));
      }
      return tarefasDTO;
   }

   public void deletarComentario(Long idComentario, Usuario usuario) {
      Comentario comentario = comentarioRepository.findByIdAndTarefaProjetoUsuario(idComentario, usuario);
      comentarioRepository.delete(comentario);
   }



}
