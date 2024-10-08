package com.example.gerenciador_projeto.service;

import com.example.gerenciador_projeto.entities.Status;
import com.example.gerenciador_projeto.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService {

   @Autowired
   private StatusRepository statusRepository;

   public Optional<Status> obterPorId(Long id) {
      return statusRepository.findById(id);
   }

   public List<Status> listar() {
      return statusRepository.findAll();
   }

}
