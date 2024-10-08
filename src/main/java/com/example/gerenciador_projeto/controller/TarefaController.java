package com.example.gerenciador_projeto.controller;

import com.example.gerenciador_projeto.dto.TarefaDTO;
import com.example.gerenciador_projeto.entities.Tarefa;
import com.example.gerenciador_projeto.entities.Usuario;
import com.example.gerenciador_projeto.service.TarefaService;
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
   public TarefaDTO criar(@RequestBody TarefaDTO tarefaDTO) {
      return tarefaService.criar(tarefaDTO);
   }

//   @GetMapping
//   public List<TarefaDTO> listar() {
//      Long userId = 1L; //ToDo: dinâmico a partir do token
//      Usuario usuario = new Usuario();
//      usuario.setId(userId);
//      return tarefaService.listarPorUsuario(usuario);
//   }
//
//   @DeleteMapping("/{id}")
//   public void excluir(@PathVariable Long id) {
//      Tarefa entidade = tarefaService.buscarPorId(id);
//      entidade.setDeleted(true);
//      TarefaDTO dto = TarefaMapper.toDTO(entidade);
//      tarefaService.criar(dto);
//   }

}
