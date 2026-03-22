Aqui está o README profissional e detalhado traduzido para português:

# API de Gestão de Vagas

## 📖 Visão Geral
**Gestão de Vagas** é uma API RESTful robusta construída com Spring Boot para gerir anúncios de emprego, empresas e candidatos. Este sistema fornece um backend simplificado para lidar com o processo de recrutamento, permitindo que as empresas se registem e publiquem vagas de emprego, enquanto os candidatos podem criar perfis para se candidatarem a essas posições.

O projeto enfatiza uma arquitetura limpa, forte validação de dados e um tratamento global de exceções para garantir uma experiência fiável e amigável para os programadores.

## 🚀 Tecnologias e Ferramentas
Este projeto utiliza um ecossistema Java moderno:
* **Java 24:** As funcionalidades e melhorias mais recentes da linguagem Java.
* **Spring Boot 3.4.4:** Framework principal para o desenvolvimento rápido da API.
* **Spring Data JPA:** Para interações fluidas com a base de dados e ORM.
* **PostgreSQL:** Base de dados relacional para armazenamento persistente de dados.
* **Lombok:** Reduz o código repetitivo (getters, setters, construtores).
* **Hibernate Validator:** Para uma validação rigorosa de entidades e payloads.
* **Docker e Docker Compose:** Ambiente de base de dados em contentores para uma configuração local simples.
* **Maven:** Gestão de dependências e automatização de builds.

## 🏗️ Arquitetura do Projeto
A aplicação está organizada em domínios modulares para separar as responsabilidades de forma eficaz:
* **Módulo de Candidato (`/modules/candidate`):** Lida com o registo de candidatos, incluindo a validação de emails, palavras-passe e nomes de utilizador. Inclui casos de uso como o `CreateCandidateUseCase` para evitar registos duplicados.
* **Módulo de Empresa (`/modules/company`):** Gere os perfis das empresas e as respetivas publicações de vagas de emprego (`JobEntity`).
* **Exceções (`/exceptions`):** Um mecanismo centralizado de tratamento de erros (`ExceptionHandlerController`) que interceta erros de validação e exceções de tempo de execução personalizadas (ex., `UserFoundException`), devolvendo mensagens de erro padronizadas, localizadas e limpas (`ErrorMessageDTO`).

## 🛠️ Pré-requisitos
Antes de executar a aplicação, certifique-se de que tem o seguinte instalado:
* [Java Development Kit (JDK) 24](https://jdk.java.net/24/)
* [Docker](https://www.docker.com/) e [Docker Compose](https://docs.docker.com/compose/)
* (Opcional) Um IDE como o IntelliJ IDEA, VS Code ou Eclipse.

## ⚙️ Como Começar (Getting Started)

### 1. Clonar o repositório
Navegue até ao diretório da sua preferência e clone o projeto.
```bash
git clone <url-do-repositorio>
cd springboot-gestao-vagas-api
```

### 2. Iniciar a Base de Dados
O projeto inclui um ficheiro `docker-compose.yml` para iniciar rapidamente uma instância do PostgreSQL. Execute o seguinte comando no diretório raiz:
```bash
docker-compose up -d
```
*Nota: Isto irá expor o PostgreSQL na porta `5432` com o utilizador padrão `admin`, palavra-passe `admin` e a base de dados `gestao_vagas`, conforme configurado no ficheiro `application.properties`.*

### 3. Executar a Aplicação
Pode executar a aplicação utilizando o Maven wrapper fornecido. Isto garante que não precisa de ter o Maven instalado manualmente na sua máquina.

**Em Linux/macOS:**
```bash
./mvnw spring-boot:run
```

**Em Windows:**
```cmd
mvnw.cmd spring-boot:run
```
A API será iniciada e estará a correr localmente em `http://localhost:8080`.

## 📡 Documentação da API (Endpoints)

### Candidatos
#### Criar um Novo Candidato
* **Endpoint:** `POST /candidate/`
* **Descrição:** Regista um novo candidato no sistema.
* **Validações:**
    * `username`: Não deve conter espaços.
    * `email`: Deve ter um formato de email válido.
    * `password`: Deve conter entre 10 e 100 caracteres.

**Corpo do Pedido (Request Body):**
```json
{
  "name": "João Silva",
  "username": "joaosilva",
  "email": "joao.silva@exemplo.com",
  "password": "PasswordSegura123!",
  "description": "Programador de Software com experiência",
  "curriculum": "Link para o currículo ou texto do mesmo"
}
```

**Respostas (Responses):**
* `200 OK`: Candidato criado com sucesso.
* `400 Bad Request`: Erros de validação (ex., email inválido, campos em falta) ou se o utilizador já existir (`UserFoundException`). As mensagens de erro estão estruturadas de forma limpa, identificando o campo específico que falhou.

## 🤝 Como Contribuir
1. Faça um Fork do projeto.
2. Crie a sua branch de funcionalidade (`git checkout -b funcionalidade/FuncionalidadeIncrivel`).
3. Faça commit das suas alterações (`git commit -m 'Adicionar FuncionalidadeIncrivel'`).
4. Faça push para a branch (`git push origin funcionalidade/FuncionalidadeIncrivel`).
5. Abra um Pull Request.
