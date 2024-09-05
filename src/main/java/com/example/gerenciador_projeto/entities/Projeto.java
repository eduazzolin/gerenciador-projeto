package com.example.gerenciador_projeto.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Projeto {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String nome;
   private String descricao;
   private LocalDateTime dataCriacao;
   private boolean isDeleted;

   @ManyToOne
   @JoinColumn(name = "id_usuario")
   private Usuario usuario;

}
