package com.example.gerenciador_projeto;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GerenciadorProjetoApplication {

   public static void main(String[] args) {
      Dotenv dotenv = Dotenv.load();
      dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));
      SpringApplication.run(GerenciadorProjetoApplication.class, args);
   }

}
