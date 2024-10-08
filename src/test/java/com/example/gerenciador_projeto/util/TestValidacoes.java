package com.example.gerenciador_projeto.util;

import com.example.gerenciador_projeto.dto.TarefaDTO;
import com.example.gerenciador_projeto.entities.Status;
import com.example.gerenciador_projeto.service.StatusService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
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
      List<Status> statusList = Arrays.asList(new Status(1L, "Em Progresso"), new Status(2L, "Concluído"));
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
        List<Status> statusList = Arrays.asList(new Status(1L, "Em Progresso"), new Status(2L, "Concluído"));
        when(statusService.listar()).thenReturn(statusList);

        TarefaDTO dto = new TarefaDTO();
        dto.setIdStatus(1L);

        boolean resultado = validacoes.validarStatusTarefa(dto);

        assertTrue(resultado);
        verify(statusService, times(1)).listar(); // Verifica se o método listar foi chamado uma vez
    }

//   @Test
//   public void testValidarProjetoTarefaDeveRetornarFalsoProjetoInexistente() {
//
//      TarefaDTO dto = new TarefaDTO();
//      dto.setIdProjeto(0L);
//
//      boolean resultado = validacoes.validarProjetoTarefa(dto);
//      assertFalse(resultado);
//   }
//
//   @Test
//   public void testValidarProjetoTarefaDeveRetornarFalsoProjetoNulo() {
//      TarefaDTO dto = new TarefaDTO();
//      boolean resultado = validacoes.validarProjetoTarefa(dto);
//      assertFalse(resultado);
//   }
//
//   @Test
//   public void testValidarProjetoTarefaDeveRetornarTrueProjetoValido() {
//      TarefaDTO dto = new TarefaDTO();
//      dto.setIdProjeto(1L);
//      boolean resultado = validacoes.validarProjetoTarefa(dto);
//      assertTrue(resultado);
//   }

}
