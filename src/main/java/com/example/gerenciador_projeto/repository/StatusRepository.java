package com.example.gerenciador_projeto.repository;

import com.example.gerenciador_projeto.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
