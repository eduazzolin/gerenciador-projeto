package com.example.gerenciador_projeto.seeder;

import com.example.gerenciador_projeto.entities.Projeto;
import com.example.gerenciador_projeto.entities.Status;
import com.example.gerenciador_projeto.entities.Tarefa;
import com.example.gerenciador_projeto.entities.Usuario;
import com.example.gerenciador_projeto.repository.ProjetoRepository;
import com.example.gerenciador_projeto.repository.StatusRepository;
import com.example.gerenciador_projeto.repository.TarefaRepository;
import com.example.gerenciador_projeto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class StartSeeder implements CommandLineRunner {

   @Autowired
   StatusRepository statusRepository;

   @Autowired
   UsuarioRepository usuarioRepository;

   @Autowired
   ProjetoRepository projetoRepository;

   @Autowired
   TarefaRepository tarefaRepository;

   @Override
   public void run(String... args) throws Exception {
      loadStatus();
      loadUsuarios();
      loadProjetos();
      loadTarefas();
   }

   private void loadStatus() {
      if (statusRepository.count() == 0) {
         statusRepository.save(new Status(1L, "Pendente", "secondary", "#6c757d"));
         statusRepository.save(new Status(2L, "Fazendo", "primary", "#0d6efd"));
         statusRepository.save(new Status(3L, "Bloqueado", "warning", "#ffc107"));
         statusRepository.save(new Status(4L, "Concluído", "success", "#198754"));
         statusRepository.save(new Status(5L, "Arquivado", "info", "#0dcaf0"));

      } else {
         System.out.println("Status já cadastrados");
      }
   }

   private void loadUsuarios() {
      if (usuarioRepository.count() == 0) {
         usuarioRepository.save(Usuario.builder()
                 .nome("Eduardo Azzolin")
                 .email("eduardo@email.com")
                 .senha("$2a$10$WBVxa1QWxyHp.w40H9lACeLlAhwRemJ.KFTZaFLU21.hS8bcC3.3.") // bcrypt hashed password
                 .dataCriacao(LocalDateTime.now()) // LocalDateTime parsing
                 .isDeleted(false)
                 .build());
      } else {
         System.out.println("Usuários já cadastrados");
      }
   }

   private void loadProjetos() {
      if (projetoRepository.count() == 0) {
         Usuario usuario = usuarioRepository.findById(1L)
                 .orElseThrow(() -> new IllegalArgumentException("Usuario not found with ID 7"));

         Projeto projeto = Projeto.builder()
                 .nome("Produção de landing page")
                 .descricao("Este é um projeto de criação de landing page para uma empresa")
                 .dataCriacao(LocalDateTime.now()) // Parse date-time
                 .isDeleted(false)
                 .usuario(usuario) // Associate with the Usuario
                 .build();

         projetoRepository.save(projeto);

      } else {
         System.out.println("Skipping creation: Projeto table is not empty.");
      }
   }

   private void loadTarefas() {
      if (tarefaRepository.count() == 0) {
         Projeto projeto = projetoRepository.findById(1L)
                 .orElseThrow(() -> new IllegalArgumentException("Projeto not found with ID 20"));
         Status status4 = statusRepository.findById(4L)
                 .orElseThrow(() -> new IllegalArgumentException("Status not found with ID 4"));
         Status status2 = statusRepository.findById(2L)
                 .orElseThrow(() -> new IllegalArgumentException("Status not found with ID 2"));
         Status status1 = statusRepository.findById(1L)
                 .orElseThrow(() -> new IllegalArgumentException("Status not found with ID 1"));
         Status status3 = statusRepository.findById(3L)
                 .orElseThrow(() -> new IllegalArgumentException("Status not found with ID 3"));
         Status status5 = statusRepository.findById(5L)
                 .orElseThrow(() -> new IllegalArgumentException("Status not found with ID 5"));

         Tarefa tarefa1 = Tarefa.builder()
                 .nome("Briefing detalhado com o cliente")
                 .descricao("Realizar uma reunião inicial com o cliente para entender os objetivos principais da landing page, discutindo a mensagem central que deve ser transmitida e o público-alvo que se deseja alcançar. O briefing incluirá a análise de requisitos como funcionalidades específicas, elementos obrigatórios e possíveis inspirações visuais e funcionais. Além disso, será detalhado o escopo do projeto e as expectativas de prazo, recursos e alinhamento com a marca.\n\nApós a reunião, documentar todas as informações coletadas em um relatório estruturado para servir como base durante o desenvolvimento. Esse relatório será compartilhado com toda a equipe envolvida no projeto para garantir um alinhamento inicial claro e reduzir retrabalhos futuros.")
                 .dataCriacao(LocalDateTime.parse("2024-11-19T20:08:18.000000"))
                 .isDeleted(false)
                 .projeto(projeto)
                 .status(status4)
                 .build();
         tarefaRepository.save(tarefa1);

         Tarefa tarefa2 = Tarefa.builder()
                 .nome("Criação de wireframes detalhados")
                 .descricao("Elaborar wireframes detalhados que representem a estrutura e o fluxo de navegação da landing page, abordando elementos como cabeçalho, chamadas para ação, seções de produtos ou serviços, depoimentos e rodapé. Esses wireframes funcionarão como um guia para o design visual e desenvolvimento, priorizando a hierarquia de informações e o impacto visual. Cada seção será analisada para garantir que esteja alinhada com os objetivos definidos no briefing.\n\nApós a criação, os wireframes serão apresentados ao cliente para aprovação preliminar. O feedback recebido será incorporado para refinar o planejamento estrutural e preparar o terreno para a próxima etapa de design visual, garantindo um alinhamento contínuo com as expectativas do cliente.")
                 .dataCriacao(LocalDateTime.parse("2024-11-19T20:08:18.000000"))
                 .isDeleted(false)
                 .projeto(projeto)
                 .status(status4)
                 .build();
         tarefaRepository.save(tarefa2);

         Tarefa tarefa3 = Tarefa.builder()
                 .nome("Definição da identidade visual e branding")
                 .descricao("Desenvolver a identidade visual da landing page com base nas diretrizes de branding fornecidas pelo cliente. A etapa inclui a seleção cuidadosa de paletas de cores, tipografia e outros elementos visuais, com o objetivo de criar uma estética coesa e atraente. Serão considerados fatores como psicologia das cores, legibilidade e impacto visual para atrair o público-alvo e transmitir profissionalismo.\n\nApós a definição inicial, serão criados exemplos práticos de aplicação da identidade visual nos wireframes previamente aprovados. Esses exemplos ajudarão o cliente a visualizar como o design final irá se comportar, permitindo ajustes finos antes de avançar para a implementação.")
                 .dataCriacao(LocalDateTime.parse("2024-11-19T20:08:18.000000"))
                 .isDeleted(false)
                 .projeto(projeto)
                 .status(status2)
                 .build();

         tarefaRepository.save(tarefa3);

         Tarefa tarefa4 = Tarefa.builder()
                 .nome("Criação de conteúdo textual otimizado")
                 .descricao("Produzir todo o conteúdo textual necessário para a landing page, garantindo que cada palavra seja estrategicamente pensada para engajar o público-alvo e conduzi-lo à ação. Textos serão adaptados para cada seção, como cabeçalhos impactantes, descrições informativas e chamadas para ação persuasivas. O tom e a voz serão ajustados para refletir a personalidade da marca, enquanto o conteúdo será otimizado para SEO, incorporando palavras-chave relevantes.\n\nAntes de finalizar, o conteúdo será revisado detalhadamente para corrigir possíveis erros de gramática ou inconsistências. Além disso, será submetido ao cliente para validação, assegurando que todos os textos estejam alinhados com os objetivos e mensagens desejadas.")
                 .dataCriacao(LocalDateTime.parse("2024-11-19T20:08:18.000000"))
                 .isDeleted(false)
                 .projeto(projeto)
                 .status(status2)
                 .build();

         tarefaRepository.save(tarefa4);

         Tarefa tarefa5 = Tarefa.builder()
                 .nome("Desenvolvimento e implementação do front-end")
                 .descricao("Desenvolver o front-end da landing page seguindo os padrões mais recentes de HTML, CSS e JavaScript. A estrutura será construída para refletir os wireframes aprovados, enquanto o design visual aplicará a identidade visual previamente definida. O foco será em responsividade, garantindo que a página funcione perfeitamente em dispositivos móveis, tablets e desktops, além de otimizar o código para melhorar o desempenho.\n\nRecursos adicionais, como animações sutis e interações dinâmicas, serão implementados para enriquecer a experiência do usuário. Ao final, a página será testada em múltiplos navegadores para garantir compatibilidade total e corrigir quaisquer problemas identificados.")
                 .dataCriacao(LocalDateTime.parse("2024-11-19T20:22:19.754622"))
                 .isDeleted(false)
                 .projeto(projeto)
                 .status(status1)
                 .build();

         tarefaRepository.save(tarefa5);

         Tarefa tarefa6 = Tarefa.builder()
                 .nome("Testes de usabilidade e responsividade")
                 .descricao("Realizar testes detalhados de usabilidade para avaliar a experiência do usuário na navegação pela landing page. Os testes incluem análise de carregamento em diferentes dispositivos e navegadores, bem como ajustes na responsividade e interatividade. Feedback será coletado com usuários reais para identificar pontos de melhoria. Além disso, serão realizados testes técnicos para identificar possíveis problemas como links quebrados, falhas de design ou incompatibilidades com dispositivos. Essas análises garantirão que a landing page entregue uma experiência fluida e profissional ao usuário final.")
                 .dataCriacao(LocalDateTime.parse("2024-11-19T20:22:25.924313"))
                 .isDeleted(false)
                 .projeto(projeto)
                 .status(status3)
                 .build();
         Tarefa tarefa7 = Tarefa.builder()
                 .nome("Aprovação e ajustes finais com o cliente")
                 .descricao("Enviar a versão final da landing page ao cliente para revisão. Durante esse processo, o cliente poderá fornecer feedback detalhado, destacando quaisquer ajustes necessários em relação ao design, conteúdo ou funcionalidade. Esse retorno será analisado e incorporado para atender às expectativas do cliente e refinar o produto final.\n\nUma vez aprovados os ajustes, a landing page será considerada pronta para a publicação, com todas as correções realizadas e a validação do cliente confirmada por escrito. Essa etapa assegura que o cliente está satisfeito com o resultado antes da entrega.")
                 .dataCriacao(LocalDateTime.parse("2024-11-19T20:08:18.000000"))
                 .isDeleted(false)
                 .projeto(projeto)
                 .status(status1)
                 .build();

         tarefaRepository.save(tarefa7);

         Tarefa tarefa8 = Tarefa.builder()
                 .nome("Publicação no servidor e configuração de domínio")
                 .descricao("Publicar a landing page no servidor de produção, configurando todos os elementos necessários, como DNS, domínio e certificados de segurança (SSL). Essa etapa garante que o site esteja funcional e acessível ao público-alvo. Durante o processo, também serão testadas todas as funcionalidades para verificar se permanecem operacionais no ambiente de produção.\n\nApós a publicação, será realizada uma revisão final diretamente no servidor para assegurar que não há inconsistências ou problemas decorrentes da migração. O cliente será notificado assim que o site estiver ao vivo, e o link será fornecido para avaliação.")
                 .dataCriacao(LocalDateTime.parse("2024-11-19T20:08:18.000000"))
                 .isDeleted(false)
                 .projeto(projeto)
                 .status(status5)
                 .build();

         tarefaRepository.save(tarefa8);

         Tarefa tarefa9 = Tarefa.builder()
                 .nome("Monitoramento e ajustes pós-lançamento")
                 .descricao("Monitorar o desempenho da landing page após a publicação, avaliando métricas como tempo de carregamento, taxa de conversão e comportamento dos usuários. Ferramentas de análise serão configuradas para fornecer dados detalhados e insights sobre a interação dos visitantes com a página.\n\nCom base nos dados coletados, ajustes contínuos serão realizados para melhorar a eficiência da página. Além disso, relatórios de desempenho serão enviados ao cliente, com recomendações para futuras otimizações e melhorias.")
                 .dataCriacao(LocalDateTime.parse("2024-11-19T20:08:18.000000"))
                 .isDeleted(false)
                 .projeto(projeto)
                 .status(status5)
                 .build();

         tarefaRepository.save(tarefa9);

      } else {
         System.out.println("Skipping creation: Tarefa table is not empty.");
      }
   }


}
