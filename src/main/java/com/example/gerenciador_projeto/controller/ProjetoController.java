package com.example.gerenciador_projeto.controller;

import com.example.gerenciador_projeto.dto.ProjetoDTO;
import com.example.gerenciador_projeto.entities.Projeto;
import com.example.gerenciador_projeto.service.ProjetoService;
import com.example.gerenciador_projeto.util.ProjetoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

   @Autowired
   private ProjetoService projetoService;

   @PostMapping
   public ProjetoDTO criar(@RequestBody ProjetoDTO projetoDTO) {
      return projetoService.criar(projetoDTO);
   }



}
