package com.example.gerenciador_projeto.util;

import com.example.gerenciador_projeto.dto.ProjetoDTO;
import com.example.gerenciador_projeto.dto.TarefaDTO;
import com.example.gerenciador_projeto.entities.Status;
import com.example.gerenciador_projeto.entities.Usuario;
import com.example.gerenciador_projeto.service.StatusService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

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

   @Test
   public void testInvalidProjetoDTO() {
      ProjetoDTO dto = new ProjetoDTO();
      dto.setNome("P");
      dto.setDescricao("D");
      dto.setIdUsuario(1L);
      dto.setDataCriacao(LocalDateTime.now());
      assertFalse(validacoes.validarProjetoDTO(dto));
   }

   @Test
   public void testValidTarefaDTO() {
      TarefaDTO dto = new TarefaDTO();
      dto.setNome("Tarefa Válida");
      dto.setDescricao("Descrição Válida");
      dto.setIdProjeto(1L);
      dto.setIdStatus(1L);
      dto.setDataCriacao(LocalDateTime.now());
      assertTrue(validacoes.validarTarefaDTO(dto));
   }

   @Test
   public void testInvalidTarefaDTO() {
      TarefaDTO dto = new TarefaDTO();
      dto.setNome("T");
      dto.setDescricao("D");
      dto.setIdProjeto(1L);
      dto.setIdStatus(1L);
      dto.setDataCriacao(LocalDateTime.now());
      assertFalse(validacoes.validarTarefaDTO(dto));
   }

   @Test
   public void testInvalidEmail() {
      assertFalse(validacoes.validarEmail("email"));
   }

   @Test
   public void testValidEmail() {
      assertTrue(validacoes.validarEmail("email@email.com"));
   }

   @Test
   public void testValidUsuario() {
      Usuario usuario = new Usuario();
      usuario.setNome("Nome Válido");
      usuario.setEmail("email@email.com");
      usuario.setSenha("senha");
      assertTrue(validacoes.validarUsuario(usuario));
   }

   @Test
   public void testInvalidUsuario() {
      Usuario usuario = new Usuario();
      usuario.setNome("N");
      usuario.setEmail("email");
      usuario.setSenha("");
      assertFalse(validacoes.validarUsuario(usuario));
   }
}
