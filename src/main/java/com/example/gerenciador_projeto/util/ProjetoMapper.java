package com.example.gerenciador_projeto.util;

import com.example.gerenciador_projeto.dto.ProjetoDTO;
import com.example.gerenciador_projeto.entities.Projeto;
import com.example.gerenciador_projeto.entities.Usuario;
import org.apache.tomcat.jni.Pool;

public class ProjetoMapper {

   public static ProjetoDTO toDTO(Projeto entity) {

      ProjetoDTO dto = new ProjetoDTO();
      dto.setId(entity.getId());
      dto.setNome(entity.getNome());
      dto.setDescricao(entity.getDescricao());
      dto.setDeleted(entity.isDeleted());
      dto.setDataCriacao(entity.getDataCriacao());
      dto.setIdUsuario(entity.getUsuario().getId());
      return dto;
   }

   public static Projeto toEntity(ProjetoDTO dto){

      Projeto entity = new Projeto();
      entity.setId(dto.getId());
      entity.setNome(dto.getNome());
      entity.setDescricao(dto.getDescricao());
      entity.setDeleted(dto.isDeleted());
      entity.setDataCriacao(dto.getDataCriacao());
      Usuario usuario = new Usuario();
      usuario.setId(dto.getIdUsuario());
      entity.setUsuario(usuario);
      return entity;
   }


}
