package com.example.gerenciador_projeto.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

   private Long id;
   private String nome;
   private String username;
   private LocalDateTime dataCriacao;
   private boolean isDeleted;
   private String password;

}
