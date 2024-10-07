package com.example.gerenciador_projeto.repository;

import com.example.gerenciador_projeto.entities.Projeto;
import com.example.gerenciador_projeto.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjetoRepository extends JpaRepository <Projeto, Long> {

   List<Projeto> findByUsuario(Usuario usuario);

}
