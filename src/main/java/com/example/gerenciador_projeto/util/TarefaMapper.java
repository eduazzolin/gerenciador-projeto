package com.example.gerenciador_projeto.util;

import com.example.gerenciador_projeto.dto.TarefaDTO;
import com.example.gerenciador_projeto.entities.Projeto;
import com.example.gerenciador_projeto.entities.Status;
import com.example.gerenciador_projeto.entities.Tarefa;

public class TarefaMapper {

   public static TarefaDTO toDTO(Tarefa entity) {

      TarefaDTO dto = new TarefaDTO();
      dto.setId(entity.getId());
      dto.setNome(entity.getNome());
      dto.setDescricao(entity.getDescricao());
      dto.setDeleted(entity.isDeleted());
      dto.setDataCriacao(entity.getDataCriacao());
      dto.setIdProjeto(entity.getProjeto().getId());
      dto.setIdStatus(entity.getStatus().getId());
      return dto;
   }

   public static Tarefa toEntity(TarefaDTO dto) {

      Tarefa entity = new Tarefa();
      entity.setId(dto.getId());
      entity.setNome(dto.getNome());
      entity.setDescricao(dto.getDescricao());
      entity.setDeleted(dto.isDeleted());
      entity.setDataCriacao(dto.getDataCriacao());
      Projeto projeto = new Projeto();
      projeto.setId(dto.getIdProjeto());
      Status status = new Status();
      status.setId(dto.getIdStatus());
      entity.setProjeto(projeto);
      entity.setStatus(status);
      return entity;
   }


}
