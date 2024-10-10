package com.example.gerenciador_projeto.service;

import com.example.gerenciador_projeto.dto.UsuarioDTO;
import com.example.gerenciador_projeto.entities.Usuario;
import com.example.gerenciador_projeto.entities.Usuario;
import com.example.gerenciador_projeto.repository.UsuarioRepository;
import com.example.gerenciador_projeto.util.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

   @Autowired
   private UsuarioRepository usuarioRepository;

   public Optional<Usuario> obterPorId(Long id) {
      return usuarioRepository.findById(id);
   }

   public UsuarioDTO criar(UsuarioDTO usuarioDTO){
      Usuario usuario = UsuarioMapper.toEntity(usuarioDTO);
      return UsuarioMapper.toDTO(usuarioRepository.save(usuario));
   }
}
