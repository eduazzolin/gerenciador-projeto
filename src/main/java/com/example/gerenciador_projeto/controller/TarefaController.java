package com.example.gerenciador_projeto.controller;

import com.example.gerenciador_projeto.dto.ComentarioDTO;
import com.example.gerenciador_projeto.dto.TarefaDTO;
import com.example.gerenciador_projeto.entities.Comentario;
import com.example.gerenciador_projeto.entities.Projeto;
import com.example.gerenciador_projeto.entities.Tarefa;
import com.example.gerenciador_projeto.entities.Usuario;
import com.example.gerenciador_projeto.service.TarefaService;
import com.example.gerenciador_projeto.util.JWTUtils;
import com.example.gerenciador_projeto.util.TarefaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

   @Autowired
   private TarefaService tarefaService;

   @PostMapping
   public TarefaDTO criar(@RequestBody TarefaDTO tarefaDTO, @RequestHeader("Authorization") String authorizationHeader) {
      String token = authorizationHeader.replace("Bearer ", "");
      Long userId = JWTUtils.getUserId(token);
      return tarefaService.criar(tarefaDTO, userId);
   }

   @GetMapping("/{id}")
   public TarefaDTO buscarPorId(@PathVariable Long id, @RequestHeader("Authorization") String authorizationHeader) {
      String token = authorizationHeader.replace("Bearer ", "");
      Long userId = JWTUtils.getUserId(token);
      return TarefaMapper.toDTO(tarefaService.buscarPorId(id, userId));
   }

   @PostMapping("/{id}/comentarios")
   public Comentario criarComentario(@RequestBody ComentarioDTO comentarioDTO, @RequestHeader("Authorization") String authorizationHeader) {
      String token = authorizationHeader.replace("Bearer ", "");
      Long userId = JWTUtils.getUserId(token);
      return tarefaService.criarComentario(comentarioDTO, userId);
   }

   @GetMapping("/{id}/comentarios")
   public List<Comentario> listarComentarios(@PathVariable Long id, @RequestHeader("Authorization") String authorizationHeader) {
      String token = authorizationHeader.replace("Bearer ", "");
      Long userId = JWTUtils.getUserId(token);
      Tarefa tarefa = tarefaService.buscarPorId(id, userId);
      return tarefaService.listarComentarios(tarefa);
   }

   @GetMapping
   public List<TarefaDTO> listar(@RequestHeader("Authorization") String authorizationHeader) {
      String token = authorizationHeader.replace("Bearer ", "");
      Long userId = JWTUtils.getUserId(token);
      Usuario usuario = new Usuario();
      usuario.setId(userId);
      return tarefaService.listarPorUsuario(usuario);
   }

   @GetMapping("/projeto/{id}")
   public List<TarefaDTO> listarPorProjeto(@RequestHeader("Authorization") String authorizationHeader, @PathVariable Long id) {
      String token = authorizationHeader.replace("Bearer ", "");
      Long userId = JWTUtils.getUserId(token);
      Usuario usuario = new Usuario();
      usuario.setId(userId);
      Projeto projeto = new Projeto();
      projeto.setId(id);
      return tarefaService.listarPorUsuarioPorProjeto(usuario, projeto);
   }


   @DeleteMapping("/{id}")
   public void excluir(@PathVariable Long id, @RequestHeader("Authorization") String authorizationHeader) {
      String token = authorizationHeader.replace("Bearer ", "");
      Long userId = JWTUtils.getUserId(token);
      Tarefa entidade = tarefaService.buscarPorId(id, userId);
      entidade.setDeleted(true);
      TarefaDTO dto = TarefaMapper.toDTO(entidade);
      tarefaService.criar(dto, userId);
   }

   @DeleteMapping("/{id}/comentarios/{idComentario}")
   public void excluirComentario(@PathVariable Long id, @PathVariable Long idComentario, @RequestHeader("Authorization") String authorizationHeader) {
      String token = authorizationHeader.replace("Bearer ", "");
      Long userId = JWTUtils.getUserId(token);
      Usuario usuario = new Usuario();
      usuario.setId(userId);
      tarefaService.deletarComentario(idComentario, usuario);
   }

}
