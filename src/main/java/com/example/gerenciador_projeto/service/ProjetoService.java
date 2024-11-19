package com.example.gerenciador_projeto.service;

import com.example.gerenciador_projeto.dto.ProjetoDTO;
import com.example.gerenciador_projeto.entities.Projeto;
import com.example.gerenciador_projeto.entities.Usuario;
import com.example.gerenciador_projeto.repository.ProjetoRepository;
import com.example.gerenciador_projeto.util.ProjetoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProjetoService {

   @Autowired
   private ProjetoRepository projetoRepository;

   public ProjetoDTO criar(ProjetoDTO projetoDTO){
      projetoDTO.setDataCriacao(LocalDateTime.now());
      Projeto projeto = ProjetoMapper.toEntity(projetoDTO);
      return ProjetoMapper.toDTO(projetoRepository.save(projeto));
   }

   public List<ProjetoDTO> listarPorUsuario(Usuario usuario) {
      List<Projeto> listaEntity = projetoRepository.findByUsuarioAndIsDeletedFalse(usuario);
      ArrayList<ProjetoDTO> listaDTO = new ArrayList<>();
      for (Projeto projeto : listaEntity) {
         listaDTO.add(ProjetoMapper.toDTO(projeto));
      }
      return listaDTO;
   }

   public Projeto buscarPorId(Long id, Long userId) {
      Usuario usuario = new Usuario();
      usuario.setId(userId);
      return projetoRepository.findByIdAndUsuario(id, usuario)
              .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));
   }

   public void excluir(Long id, Long userId) {
      Projeto entidade = buscarPorId(id, userId);
      entidade.setDeleted(true);
      ProjetoDTO dto = ProjetoMapper.toDTO(entidade);
      criar(dto);
   }



}
