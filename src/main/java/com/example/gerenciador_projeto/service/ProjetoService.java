package com.example.gerenciador_projeto.service;

import com.example.gerenciador_projeto.dto.ProjetoDTO;
import com.example.gerenciador_projeto.entities.Projeto;
import com.example.gerenciador_projeto.entities.Usuario;
import com.example.gerenciador_projeto.repository.ProjetoRepository;
import com.example.gerenciador_projeto.util.ProjetoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

   @Autowired
   private ProjetoRepository projetoRepository;

   public ProjetoDTO criar(ProjetoDTO projetoDTO){
      Projeto projeto = ProjetoMapper.toEntity(projetoDTO);
      return ProjetoMapper.toDTO(projetoRepository.save(projeto));
   }

//   public List<ProjetoDTO> listarPorUsuario(Usuario usuario) {
//
//   }

}
