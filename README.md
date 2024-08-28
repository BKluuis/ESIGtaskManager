# Sistema de Gerenciamento de Tarefas

## Visão Geral
Este projeto foi desenvolvido como parte de uma avaliação técnica para o Grupo ESIG. O objetivo foi implementar um
sistema de gerenciamento de tarefas utilizando JavaServer Faces (JSF) e PostgreSQL para persistência de dados.

O sistema é um CRUD de tarefas com 3 páginas: listagem, edição e criação de tarefas, estando a deleção presente na página de listagem. Além de tarefas, o sistema contém uma implementação
e armazenamento no banco de dados de um modelo simples de usuário, que é relacionado à tarefa pelo campo responsável. Com a utilização desse modelo, é possível
expandir funcionalidades como auditoria, adição de informações como foto, dados de contato, etc.

## Instruções de uso
- **Página inicial**: É nesta página em que você pode visualizar todas as tarefas existentes. Ela contém um card com opções de pesquisa e uma tabela ordenável com as tarefas filtradas. Cada tarefa contém 3 botões de ação:
    -  Editar, que leva à tela de edição desta tarefa;
    -  Excluir, que abre um prompt de confirmação perguntando se o usuário deseja excluir a tarefa;
    -  Concluir, que altera o status da tarefa para concluído;
- **Página de edição**: Esta página é acessável pela tela inicial ao clicar na ação "Editar" de uma tarefa. Nela, é possível alterar todas as informações sobre a tarefa menos o id, pois é de uso interno ao banco de dados.
  As alterações só são salvas no banco se o usuário clicar no botão "Salvar" e confirmar o prompt de confirmação.
- **Página de nova tarefa**: Esta página pode ser acessada pela barra de navegação no botão "Nova tarefa". Nela, o usuário deve preencher todas as informações de uma tarefa. A tarefa só é salva ao clicar no botão "Salvar" e confirmar o prompt de confirmação.

## Tecnologias Utilizadas
- **JavaServer Faces (JSF)**: Utilizado para construir a interface do usuário.
- **PrimeFaces**: Biblioteca JSF usada para melhorar os componentes da interface.
- **Spring Boot**: Framework utilizado para aplicações web
- **PostgreSQL**: Banco de dados usado para persistência de dados.
- **JPA (Java Persistence API)**: Usado para mapeamento objeto-relacional.
- **JoinFaces**: Integração e configuração entre JSF e Spring Boot.
- **Maven**: Gerenciamento de dependências e automação de build.

## Funcionalidades Implementadas
- [x] **A)** Aplicação Java Web utilizando JavaServer Faces (JSF).
- [x] **B)** Persistência de dados em um banco de dados PostgreSQL.
- [x] **C)** Utilização de JPA para mapeamento objeto-relacional.
- [x] **F)** Virtualização com docker

## Instruções de Execução (compilação local)

### Pré-requisitos
- Java JDK 21.
- Apache Maven 3.6.0 ou superior.
- PostgreSQL 13 ou superior.

### Configuração do Banco de Dados
1. Crie um banco de dados no PostgreSQL:
```sql
CREATE DATABASE task_management;
```
2. Configure o arquivo application.properties com as credenciais do seu banco de dados:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/task_management
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

### Executando o Projeto
1. Clone o repositório:

```bash
git clone git@github.com:BKluuis/ESIGtaskManager.git
cd ESIGtaskManager
```
2. Compile e execute o projeto usando Maven:

```bash 
mvn clean install
mvn spring-boot:run
```
3. Acesse a aplicação em http://localhost:8080.

## Instruções de Execução (Docker)

### Pré-requisitos
- Docker 27.0.3 ou superior.
- Docker Compose v2.28.1 ou superior.

### Executando o Projeto
1. Clone o repositório:

```bash
git clone git@github.com:BKluuis/ESIGtaskManager.git
cd ESIGtaskManager
```
2. Execute o docker-compose:

```bash 
docker-compose up
```
3. Acesse a aplicação em http://localhost:8080.