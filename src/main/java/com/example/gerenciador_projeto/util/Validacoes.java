package com.example.gerenciador_projeto.util;

import com.example.gerenciador_projeto.dto.ProjetoDTO;
import com.example.gerenciador_projeto.dto.TarefaDTO;
import com.example.gerenciador_projeto.entities.Projeto;
import com.example.gerenciador_projeto.entities.Status;
import com.example.gerenciador_projeto.entities.Usuario;
import com.example.gerenciador_projeto.service.ProjetoService;
import com.example.gerenciador_projeto.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Validacoes {


   @Autowired
   private ProjetoService projetoService;

   @Autowired
   private StatusService statusService;

   public boolean validarStatusTarefa(TarefaDTO dto) {
      if (dto.getIdStatus() == null) {
         return false;
      }
      List<Status> listaStatus = statusService.listar();
      for (Status status : listaStatus) {
         if (status.getId() == dto.getIdStatus()) {
            return true;
         }
      }
      return false;
   }

   public boolean validarProjetoTarefa(TarefaDTO dto, Usuario usuarioRequisicao) {
      if (dto.getIdProjeto() == null) {
         return false;
      }
      ArrayList<ProjetoDTO> lista = (ArrayList<ProjetoDTO>) projetoService.listarPorUsuario(usuarioRequisicao);
      for (ProjetoDTO projetoDTO : lista) {
         if (projetoDTO.getId() == dto.getIdProjeto()) {
            return true;
         }
      }
      return false;
   }


}
