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
public class ComentarioDTO {

   private Long id;
   private LocalDateTime dataCriacao;
   private String comentario;
   private Long idTarefa;

}
