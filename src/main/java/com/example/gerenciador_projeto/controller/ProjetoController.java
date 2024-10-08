package com.example.gerenciador_projeto.controller;

import com.example.gerenciador_projeto.dto.ProjetoDTO;
import com.example.gerenciador_projeto.entities.Projeto;
import com.example.gerenciador_projeto.entities.Usuario;
import com.example.gerenciador_projeto.service.ProjetoService;
import com.example.gerenciador_projeto.util.ProjetoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

   @Autowired
   private ProjetoService projetoService;

   @PostMapping
   public ProjetoDTO criar(@RequestBody ProjetoDTO projetoDTO) {
      return projetoService.criar(projetoDTO);
   }

   @GetMapping
   public List<ProjetoDTO> listar() {
      Long userId = 1L; //ToDo: dinâmico a partir do token
      Usuario usuario = new Usuario();
      usuario.setId(userId);
      return projetoService.listarPorUsuario(usuario);
   }

   @DeleteMapping("/{id}")
   public void excluir(@PathVariable Long id) {
      Projeto entidade = projetoService.buscarPorId(id);
      entidade.setDeleted(true);
      ProjetoDTO dto = ProjetoMapper.toDTO(entidade);
      projetoService.criar(dto);
   }

}
