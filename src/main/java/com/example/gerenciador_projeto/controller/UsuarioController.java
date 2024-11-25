package com.example.gerenciador_projeto.controller;

import com.example.gerenciador_projeto.dto.TokenDTO;
import com.example.gerenciador_projeto.dto.UsuarioDTO;
import com.example.gerenciador_projeto.entities.Usuario;
import com.example.gerenciador_projeto.service.JwtService;
import com.example.gerenciador_projeto.service.UsuarioService;
import com.example.gerenciador_projeto.util.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

   @Autowired
   private UsuarioService service;

   @Autowired
   private JwtService jwtService;


   @PostMapping
   public ResponseEntity criar(@RequestBody UsuarioDTO dto) {

      Usuario usuario = UsuarioMapper.toEntity(dto);

      try {
         Usuario usuarioSalvo = service.salvar(usuario);
         return new ResponseEntity(HttpStatus.CREATED);
      } catch (Exception e) {
         return ResponseEntity.badRequest().body(e.getMessage());
      }

   }

   @PostMapping("/autenticar")
   public ResponseEntity<?> autenticar(@RequestBody UsuarioDTO dto) {
      System.out.println(dto);
      try {
         Usuario usurioAutenticado = service.autenticar(dto.getEmail(), dto.getSenha());
         TokenDTO tokenDTO = new TokenDTO(usurioAutenticado.getNome(), jwtService.generateToken(usurioAutenticado));


         return ResponseEntity.ok(tokenDTO);
      } catch (Exception e) {
         return ResponseEntity.badRequest().body(e.getMessage());
      }
   }

}
