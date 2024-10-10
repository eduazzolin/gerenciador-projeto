package com.example.gerenciador_projeto.controller;

import com.example.gerenciador_projeto.dto.UsuarioDTO;
import com.example.gerenciador_projeto.entities.Usuario;
import com.example.gerenciador_projeto.entities.Usuario;
import com.example.gerenciador_projeto.service.UsuarioService;
import com.example.gerenciador_projeto.util.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

   @Autowired
   private UsuarioService usuarioService;

   @PostMapping
   public UsuarioDTO criar(@RequestBody UsuarioDTO usuarioDTO) {
      return usuarioService.criar(usuarioDTO);
   }



}
