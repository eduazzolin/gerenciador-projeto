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
public class Comentario {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private LocalDateTime dataCriacao;
   private String comentario;

   @ManyToOne
   @JoinColumn(name = "id_tarefa")
   private Tarefa tarefa;

}
