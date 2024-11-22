package com.example.gerenciador_projeto.seeder;

import com.example.gerenciador_projeto.entities.Status;
import com.example.gerenciador_projeto.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StatusSeeder implements CommandLineRunner {

   @Autowired
   StatusRepository statusRepository;

   @Override
   public void run(String... args) throws Exception {
      loadUserData();
   }

   private void loadUserData() {
      if (statusRepository.count() == 0) {
         statusRepository.save(new Status(1L, "Pendente", "secondary", "#6c757d"));
         statusRepository.save(new Status(2L, "Fazendo", "primary", "#0d6efd"));
         statusRepository.save(new Status(3L, "Bloqueado", "warning", "#ffc107"));
         statusRepository.save(new Status(4L, "Concluído", "success", "#198754"));
         statusRepository.save(new Status(5L, "Arquivado", "info", "#0dcaf0"));

      } else {
         System.out.println("Status já cadastrados");
      }
      System.out.println(statusRepository.count());
   }


}
