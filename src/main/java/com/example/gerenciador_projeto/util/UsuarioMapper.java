package com.example.gerenciador_projeto.util;

import com.example.gerenciador_projeto.dto.UsuarioDTO;
import com.example.gerenciador_projeto.entities.Usuario;

public class UsuarioMapper {

   public static UsuarioDTO toDTO(Usuario entity) {

      UsuarioDTO dto = new UsuarioDTO();
      dto.setId(entity.getId());
      dto.setNome(entity.getNome());
      dto.setSenha(entity.getEmail());
      dto.setDeleted(entity.isDeleted());
      dto.setDataCriacao(entity.getDataCriacao());
      dto.setSenha(entity.getSenha());
      return dto;

   }

   public static Usuario toEntity(UsuarioDTO dto) {

      Usuario entity = new Usuario();
      entity.setDataCriacao(dto.getDataCriacao());
      entity.setId(dto.getId());
      entity.setNome(dto.getNome());
      entity.setEmail(dto.getEmail());
      entity.setDeleted(dto.isDeleted());
      entity.setSenha(dto.getSenha());
      return entity;

   }

}
