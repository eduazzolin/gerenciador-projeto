package com.example.gerenciador_projeto.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjetoDTO {

   private Long id;
   private String nome;
   @Column(length = 1000)
   private String descricao;
   private LocalDateTime dataCriacao;
   private boolean isDeleted;
   private Long idUsuario;


}
