package com.example.gerenciador_projeto.controller;

import com.example.gerenciador_projeto.dto.TarefaDTO;
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

   @GetMapping
   public List<TarefaDTO> listar(@RequestHeader("Authorization") String authorizationHeader) {
      String token = authorizationHeader.replace("Bearer ", "");
      Long userId = JWTUtils.getUserId(token);
      Usuario usuario = new Usuario();
      usuario.setId(userId);
      return tarefaService.listarPorUsuario(usuario);
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

}
