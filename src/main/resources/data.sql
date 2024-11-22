INSERT INTO status (id, nome, cor, hex) VALUES (1, 'Pendente', 'secondary', '#6c757d');
INSERT INTO status (id, nome, cor, hex) VALUES (2, 'Fazendo', 'primary', '#0d6efd');
INSERT INTO status (id, nome, cor, hex) VALUES (3, 'Bloqueado', 'warning', '#ffc107');
INSERT INTO status (id, nome, cor, hex) VALUES (4, 'Concluído', 'success', '#198754');
INSERT INTO status (id, nome, cor, hex) VALUES (5, 'Arquivado', 'info', '#0dcaf0');


INSERT INTO usuario (id, data_criacao, email, is_deleted, nome, senha, password, username) VALUES (7, '2024-11-20 11:26:43.626177', 'eduardo@email.com', false, 'Eduardo Azzolins', '$2a$10$WBVxa1QWxyHp.w40H9lACeLlAhwRemJ.KFTZaFLU21.hS8bcC3.3.', null, null);


INSERT INTO projeto (id, data_criacao, descricao, is_deleted, nome, id_usuario) VALUES (20, '2024-11-19 20:07:58.000000', 'Este é um projeto de criação de landing page para uma empresa', false, 'Produção de landing page', 7);

INSERT INTO tarefa (id, data_criacao, descricao, is_deleted, nome, id_projeto, id_status) VALUES (28, '2024-11-19 20:08:18.000000', 'Realizar uma reunião inicial com o cliente para entender os objetivos principais da landing page, discutindo a mensagem central que deve ser transmitida e o público-alvo que se deseja alcançar. O briefing incluirá a análise de requisitos como funcionalidades específicas, elementos obrigatórios e possíveis inspirações visuais e funcionais. Além disso, será detalhado o escopo do projeto e as expectativas de prazo, recursos e alinhamento com a marca.

Após a reunião, documentar todas as informações coletadas em um relatório estruturado para servir como base durante o desenvolvimento. Esse relatório será compartilhado com toda a equipe envolvida no projeto para garantir um alinhamento inicial claro e reduzir retrabalhos futuros.', false, 'Briefing detalhado com o cliente', 20, 4);
INSERT INTO tarefa (id, data_criacao, descricao, is_deleted, nome, id_projeto, id_status) VALUES (29, '2024-11-19 20:08:18.000000', 'Elaborar wireframes detalhados que representem a estrutura e o fluxo de navegação da landing page, abordando elementos como cabeçalho, chamadas para ação, seções de produtos ou serviços, depoimentos e rodapé. Esses wireframes funcionarão como um guia para o design visual e desenvolvimento, priorizando a hierarquia de informações e o impacto visual. Cada seção será analisada para garantir que esteja alinhada com os objetivos definidos no briefing.

Após a criação, os wireframes serão apresentados ao cliente para aprovação preliminar. O feedback recebido será incorporado para refinar o planejamento estrutural e preparar o terreno para a próxima etapa de design visual, garantindo um alinhamento contínuo com as expectativas do cliente.', false, 'Criação de wireframes detalhados', 20, 4);
INSERT INTO tarefa (id, data_criacao, descricao, is_deleted, nome, id_projeto, id_status) VALUES (30, '2024-11-19 20:08:18.000000', 'Desenvolver a identidade visual da landing page com base nas diretrizes de branding fornecidas pelo cliente. A etapa inclui a seleção cuidadosa de paletas de cores, tipografia e outros elementos visuais, com o objetivo de criar uma estética coesa e atraente. Serão considerados fatores como psicologia das cores, legibilidade e impacto visual para atrair o público-alvo e transmitir profissionalismo.

Após a definição inicial, serão criados exemplos práticos de aplicação da identidade visual nos wireframes previamente aprovados. Esses exemplos ajudarão o cliente a visualizar como o design final irá se comportar, permitindo ajustes finos antes de avançar para a implementação.', false, 'Definição da identidade visual e branding', 20, 2);
INSERT INTO tarefa (id, data_criacao, descricao, is_deleted, nome, id_projeto, id_status) VALUES (31, '2024-11-19 20:08:18.000000', 'Produzir todo o conteúdo textual necessário para a landing page, garantindo que cada palavra seja estrategicamente pensada para engajar o público-alvo e conduzi-lo à ação. Textos serão adaptados para cada seção, como cabeçalhos impactantes, descrições informativas e chamadas para ação persuasivas. O tom e a voz serão ajustados para refletir a personalidade da marca, enquanto o conteúdo será otimizado para SEO, incorporando palavras-chave relevantes.

Antes de finalizar, o conteúdo será revisado detalhadamente para corrigir possíveis erros de gramática ou inconsistências. Além disso, será submetido ao cliente para validação, assegurando que todos os textos estejam alinhados com os objetivos e mensagens desejadas.', false, 'Criação de conteúdo textual otimizado', 20, 2);
INSERT INTO tarefa (id, data_criacao, descricao, is_deleted, nome, id_projeto, id_status) VALUES (32, '2024-11-19 20:22:19.754622', 'Desenvolver o front-end da landing page seguindo os padrões mais recentes de HTML, CSS e JavaScript. A estrutura será construída para refletir os wireframes aprovados, enquanto o design visual aplicará a identidade visual previamente definida. O foco será em responsividade, garantindo que a página funcione perfeitamente em dispositivos móveis, tablets e desktops, além de otimizar o código para melhorar o desempenho.

Recursos adicionais, como animações sutis e interações dinâmicas, serão implementados para enriquecer a experiência do usuário. Ao final, a página será testada em múltiplos navegadores para garantir compatibilidade total e corrigir quaisquer problemas identificados.', false, 'Desenvolvimento e implementação do front-end', 20, 1);
INSERT INTO tarefa (id, data_criacao, descricao, is_deleted, nome, id_projeto, id_status) VALUES (33, '2024-11-19 20:22:25.924313', 'Realizar testes detalhados de usabilidade para avaliar a experiência do usuário na navegação pela landing page. Os testes incluem análise de carregamento em diferentes dispositivos e navegadores, bem como ajustes na responsividade e interatividade. Feedback será coletado com usuários reais para identificar pontos de melhoria.

Além disso, serão realizados testes técnicos para identificar possíveis problemas como links quebrados, falhas de design ou incompatibilidades com dispositivos. Essas análises garantirão que a landing page entregue uma experiência fluida e profissional ao usuário final.', false, 'Testes de usabilidade e responsividade', 20, 3);
INSERT INTO tarefa (id, data_criacao, descricao, is_deleted, nome, id_projeto, id_status) VALUES (34, '2024-11-19 20:08:18.000000', 'Enviar a versão final da landing page ao cliente para revisão. Durante esse processo, o cliente poderá fornecer feedback detalhado, destacando quaisquer ajustes necessários em relação ao design, conteúdo ou funcionalidade. Esse retorno será analisado e incorporado para atender às expectativas do cliente e refinar o produto final.

Uma vez aprovados os ajustes, a landing page será considerada pronta para a publicação, com todas as correções realizadas e a validação do cliente confirmada por escrito. Essa etapa assegura que o cliente está satisfeito com o resultado antes da entrega.', false, 'Aprovação e ajustes finais com o cliente', 20, 1);
INSERT INTO tarefa (id, data_criacao, descricao, is_deleted, nome, id_projeto, id_status) VALUES (35, '2024-11-19 20:08:18.000000', 'Publicar a landing page no servidor de produção, configurando todos os elementos necessários, como DNS, domínio e certificados de segurança (SSL). Essa etapa garante que o site esteja funcional e acessível ao público-alvo. Durante o processo, também serão testadas todas as funcionalidades para verificar se permanecem operacionais no ambiente de produção.

Após a publicação, será realizada uma revisão final diretamente no servidor para assegurar que não há inconsistências ou problemas decorrentes da migração. O cliente será notificado assim que o site estiver ao vivo, e o link será fornecido para avaliação.', false, 'Publicação no servidor e configuração de domínio', 20, 5);
INSERT INTO tarefa (id, data_criacao, descricao, is_deleted, nome, id_projeto, id_status) VALUES (36, '2024-11-19 20:08:18.000000', 'Monitorar o desempenho da landing page após a publicação, avaliando métricas como tempo de carregamento, taxa de conversão e comportamento dos usuários. Ferramentas de análise serão configuradas para fornecer dados detalhados e insights sobre a interação dos visitantes com a página.

Com base nos dados coletados, ajustes contínuos serão realizados para melhorar a eficiência da página. Além disso, relatórios de desempenho serão enviados ao cliente, com recomendações para futuras otimizações e melhorias.', false, 'Monitoramento e ajustes pós-lançamento', 20, 5);

