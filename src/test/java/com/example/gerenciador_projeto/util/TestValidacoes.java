package com.example.gerenciador_projeto.util;

import com.example.gerenciador_projeto.dto.ProjetoDTO;
import com.example.gerenciador_projeto.dto.TarefaDTO;
import com.example.gerenciador_projeto.entities.Status;
import com.example.gerenciador_projeto.service.StatusService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TestValidacoes {

   @Mock
   private StatusService statusService;

   @InjectMocks
   private Validacoes validacoes;

   @BeforeEach
   public void setup() {
      MockitoAnnotations.openMocks(this);
   }


   @Test
   public void testValidarStatusTarefaDeveRetornarFalsoStatusInexistente() {
      List<Status> statusList = Arrays.asList(new Status(1L, "Em Progresso", "secondary", "#6c757d"), new Status(2L, "Concluído", "primary", "#0d6efd"));
      when(statusService.listar()).thenReturn(statusList);

      TarefaDTO dto = new TarefaDTO();
      dto.setIdStatus(0L);

      boolean resultado = validacoes.validarStatusTarefa(dto);

      assertFalse(resultado);
      verify(statusService, times(1)).listar(); // Verifica se o método listar foi chamado uma vez
   }

   @Test
   public void testValidarStatusTarefaDeveRetornarFalsoStatusNulo() {
      TarefaDTO dto = new TarefaDTO();

      boolean resultado = validacoes.validarStatusTarefa(dto);

      assertFalse(resultado);
      verifyNoInteractions(statusService);
   }

   @Test
   public void testValidarStatusTarefaDeveRetornarTrueStatusValido() {
      List<Status> statusList = Arrays.asList(new Status(1L, "Em Progresso", "secondary", "#6c757d"), new Status(2L, "Concluído", "primary", "#0d6efd"));
      when(statusService.listar()).thenReturn(statusList);

      TarefaDTO dto = new TarefaDTO();
      dto.setIdStatus(1L);

      boolean resultado = validacoes.validarStatusTarefa(dto);

      assertTrue(resultado);
      verify(statusService, times(1)).listar(); // Verifica se o método listar foi chamado uma vez
   }

   @Test
   public void testValidProjetoDTO() {
      ProjetoDTO dto = new ProjetoDTO();
      dto.setNome("Projeto Válido");
      dto.setDescricao("Descrição Válida");
      dto.setIdUsuario(1L);
      dto.setDataCriacao(LocalDateTime.now());
      assertTrue(validacoes.validarProjetoDTO(dto));
   }
}
