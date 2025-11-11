# Este é um Projeto: Gerenciamento de Usuários (Kotlin + Spring Boot + Thymeleaf)
### Este documento descreve um projeto de aplicação web para o gerenciamento básico de usuários (CRUD), construído com uma stack de tecnologias moderna, focada em Kotlin para o backend e renderização do lado do servidor com Thymeleaf.
### A aplicação utiliza o XAMPP para fornecer o ambiente de banco de dados MySQL, que é facilmente gerenciado através do phpMyAdmin.

## 🛠️ Tecnologias Utilizadas
* Backend: Spring Boot (com Kotlin)
* Linguagem: Kotlin
* Template Engine (Frontend): Thymeleaf
* Estilização (Frontend): Bootstrap
* Banco de Dados: MySQL
* Ambiente de BD: XAMPP (inclui MySQL e phpMyAdmin)
* Gerenciador de Dependências: Maven ou Gradle
* Camada de Dados: Spring Data JPA

## 🏛️ Arquitetura e Como Funciona
### A aplicação segue o padrão Model-View-Controller (MVC), onde o Spring Boot orquestra todo o fluxo de dados.

#### 1. O Fluxo da Requisição
  1. Usuário Interage: O usuário acessa uma URL no navegador (localhost:8080./home).
  2. Controller (Spring/Kotlin): O Spring Boot identifica qual método no @Controller (escrito em Kotlin) deve lidar com essa requisição.
  3. Service/Repository (JPA): O Controller chama a camada de serviço (Service) que, por sua vez, usa o Spring Data JPA (Repository) para buscar os dados no banco de dados MySQL (iniciado pelo XAMPP).
  4. Model (Dados): O JPA retorna uma lista de objetos User (data class em Kotlin: Usuario).
  5. View (Thymeleaf): O Spring Boot injeta essa lista de usuários (o "Model") em um template Thymeleaf (/home.html).
  6. Renderização: O Thymeleaf processa o HTML no lado do servidor. Ele usa suas tags especiais (como th...) para criar as linhas da tabela dinamicamente com os dados dos usuários.
  7. Resposta (HTML + Bootstrap): O servidor envia o HTML final e pronto para o navegador. O navegador então aplica os estilos do Bootstrap (CSS) para que a tabela e os botões fiquem visualmente agradáveis e responsivos.

#### 2. O Papel de Cada Tecnologia
###### O Spring Boot (com Kotlin)
* É o coração da aplicação. Ele fornece o servidor web embutido (Tomcat), a injeção de dependências e a estrutura MVC. Usar Kotlin em vez de Java torna o código mais conciso e seguro (graças ao seu sistema de tipos nulos).
* @Controller: Mapeia URLs para métodos que retornam o nome do template Thymeleaf a ser renderizado.
* @Repository: Interface do Spring Data JPA que magicamente gera as queries SQL (ex: findAll(), findById()).
* data class Usuario: Define o "Model" (a entidade que será salva no banco).

##### Thymeleaf
* Permite criar HTML dinâmico. A grande vantagem é que ele parece HTML normal quando aberto em um navegador (é um "template natural"), mas o Spring Boot o processa para inserir os dados.

##### Bootstrap
* É a camada de apresentação puramente visual. Ele não tem lógica de backend. É apenas um conjunto de arquivos CSS e JS que são linkados no HTML do Thymeleaf para estilizar os componentes (tabelas, formulários, botões, navbars) de forma rápida e profissional.

##### XAMPP e phpMyAdmin
* Neste projeto, o XAMPP é usado apenas para uma coisa: iniciar o servidor de banco de dados MySQL.
* XAMPP: É o "launcher" que liga o serviço do MySQL.
* phpMyAdmin: É uma ferramenta de interface gráfica (GUI) que você acessa pelo navegador (http://localhost/phpmyadmin). Ele não faz parte da aplicação Spring, mas é usado durante o desenvolvimento para:
  * Criar o banco de dados inicial (usuarioapp).
  * Criar a tabela (usuario)
  * Visualizar os dados que o Spring Boot está salvando, atualizando ou excluindo
 
##### ✨ Funcionalidades Principais (CRUD)
* O projeto implementa as quatro operações básicas de gerenciamento:
  * Create (Criar): Uma página com um formulário (<form>) estilizado com Bootstrap. Ao submeter, os dados são enviados para um endpoint @PostMapping no Controller, que salva o novo usuário no banco.
  * Read (Ler): A página principal () que exibe todos os usuários cadastrados em (Bootstrap) preenchida dinamicamente pelo th:each (Thymeleaf).
  * Update (Atualizar): Um link "Editar" em cada usuário que leva a um formulário pré-preenchido com os dados atuais (usando th:value). Ao salvar, o Spring Data JPA atualiza o registro existente.
  * Delete (Excluir): Um botão "Excluir" em cada linha que, ao ser clicado, chama um endpoint no Controller (via POST ou GET) que remove o usuário do banco de dados pelo seu ID.


