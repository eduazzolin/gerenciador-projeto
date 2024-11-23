package com.example.gerenciador_projeto.util;

import com.example.gerenciador_projeto.dto.ProjetoDTO;
import com.example.gerenciador_projeto.dto.TarefaDTO;
import com.example.gerenciador_projeto.entities.Status;
import com.example.gerenciador_projeto.entities.Usuario;
import com.example.gerenciador_projeto.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Validacoes {


   public boolean validarProjetoDTO(ProjetoDTO dto) {
      if (dto.getNome() == null || dto.getNome().isEmpty() || dto.getNome().length() > 50 || dto.getNome().length() < 3) {
         return false;
      }
      if (dto.getDescricao() == null || dto.getDescricao().isEmpty() || dto.getDescricao().length() > 999 || dto.getDescricao().length() < 3) {
         return false;
      }
      if (dto.getIdUsuario() == null) {
         return false;
      }
      if (dto.getDataCriacao() == null) {
         return false;
      }
      return true;
   }

   public boolean validarTarefaDTO(TarefaDTO dto) {
      if (dto.getNome() == null || dto.getNome().isEmpty() || dto.getNome().length() > 100 || dto.getNome().length() < 3) {
         return false;
      }
      if (dto.getDescricao() == null || dto.getDescricao().isEmpty() || dto.getDescricao().length() > 999) {
         return false;
      }
      if (dto.getIdProjeto() == null) {
         return false;
      }
      if (dto.getIdStatus() == null) {
         return false;
      }
      if (dto.getDataCriacao() == null) {
         return false;
      }
      return true;
   }

   public boolean validarEmail(String email) {
      String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
      return email != null && email.matches(emailRegex);
   }

   public boolean validarUsuario(Usuario usuario) {
      if (usuario.getNome() == null || usuario.getNome().isEmpty() || usuario.getNome().length() > 255) {
         return false;
      }
      if (usuario.getEmail() == null || usuario.getEmail().isEmpty() || !validarEmail(usuario.getEmail())) {
         return false;
      }
      if (usuario.getSenha() == null || usuario.getSenha().isEmpty()) {
         return false;
      }
      return true;
   }


}
