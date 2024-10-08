package com.example.gerenciador_projeto.service;

import com.example.gerenciador_projeto.dto.ProjetoDTO;
import com.example.gerenciador_projeto.dto.TarefaDTO;
import com.example.gerenciador_projeto.entities.Projeto;
import com.example.gerenciador_projeto.entities.Tarefa;
import com.example.gerenciador_projeto.entities.Usuario;
import com.example.gerenciador_projeto.repository.ProjetoRepository;
import com.example.gerenciador_projeto.repository.TarefaRepository;
import com.example.gerenciador_projeto.util.ProjetoMapper;
import com.example.gerenciador_projeto.util.TarefaMapper;
import com.example.gerenciador_projeto.util.Validacoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TarefaService {

   @Autowired
   private TarefaRepository tarefaRepository;

   @Autowired
   private Validacoes validacoes;

   public TarefaDTO criar(TarefaDTO tarefaDTO) {

      Usuario usuarioRequisicao = new Usuario();
      usuarioRequisicao.setId(1L); // todo: deixar dinÂmico

      if (
              !validacoes.validarStatusTarefa(tarefaDTO) ||
                      !validacoes.validarProjetoTarefa(tarefaDTO, usuarioRequisicao)

      ) {
         return null;
      }

      Tarefa tarefa = TarefaMapper.toEntity(tarefaDTO);
      return TarefaMapper.toDTO(tarefaRepository.save(tarefa));
   }

   public Tarefa buscarPorId(Long id) {
      return tarefaRepository.findById(id).orElse(null);
   }


}
