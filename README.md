# Sistema de Gerenciamento de Tarefas em Equipe (SGTE)

<p>Este projeto visa auxiliar equipes na organização e acompanhamento de tarefas. Com funcionalidades intuitivas, o sistema melhora a eficiência no gerenciamento de projetos e proporciona maior colaboração entre os membros da equipe.</p>

---

## Funcionalidades

### **1. Gerenciamento de Tarefas**
- **Criar Tarefas**: Adicione novas tarefas com informações como nome, status, detalhes, usuário atribuído, e horários de criação e conclusão.
- **Atualizar Tarefas**: Conclua ou edite as tarefas diretamente na interface.
- **Excluir Tarefas**: Remova tarefas obsoletas ou concluídas.

### **2. Visualização de Tarefas**
A interface exibe uma lista com as seguintes informações:
- **Nome**: Nome da tarefa.
- **Status**: PENDENTE, EM PROGRESSO ou CONCLUÍDA.
- **Detalhes**: Informações adicionais da tarefa.
- **Usuário**: Responsável atribuído à tarefa.
- **Hora Criação**: Registro de quando a tarefa foi criada.
- **Hora Conclusão**: Marca o momento em que a tarefa foi finalizada.
- **Ações**: Botões para concluir ou excluir tarefas.

### **3. Painel Interativo**
- Visualização clara de tarefas organizadas por status.
- Filtros para facilitar a busca de tarefas específicas.

---

## Tecnologias Utilizadas

### **Frontend**
- **React.js**: Para criação de uma interface de usuário dinâmica e responsiva.
- **CSS (Bootstrap)**: Para estilização e design responsivo.

### **Backend**
- **Java 17 com Spring Boot**: Framework para APIs RESTful e lógica de negócio.
- **Maven**: Gerenciador de dependências e build.
- **Docker**: Containerização para ambientes consistentes e escaláveis.

### **Banco de Dados**
- **PostgreSQL**: Banco de dados relacional para armazenamento das informações de tarefas e usuários.

---

## Pré-requisitos

- **Java 17+** instalado.
- **Maven** configurado no ambiente.
- **Node.js** para o frontend.
- **Docker** para execução de containers.

---

## Como Rodar o Projeto

### **1. Backend (Spring Boot)**

#### Clone o repositório:
```bash
git clone https://github.com/seuusuario/sgte-backend.git
cd sgte-backend
```

#### Configure o banco de dados PostgreSQL:

Crie um banco de dados chamado `gerenciamento_tarefas` com o usuário `admin` e senha `admin`.
```sql
CREATE DATABASE gerenciamento_tarefas;
```

Configure o arquivo `application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/gerenciamento_tarefas
spring.datasource.username=admin
spring.datasource.password=admin
spring.jpa.hibernate.ddl-auto=update
```

Compile e execute:
```bash
mvn clean install
mvn spring-boot:run
```

### 2. Frontend (React.js)
Clone o repositório:
```bash
git clone https://github.com/seuusuario/sgte-frontend.git
cd sgte-frontend
```

Instale as dependências:
```bash
npm install
```

Execute o servidor de desenvolvimento:
```bash
npm start
```

### 3. Docker
Certifique-se de que o Docker esteja instalado e configurado. Utilize o arquivo `docker-compose.yml` abaixo para rodar todo o sistema:
```yaml
version: '3.8'

services:
  backend:
    build:
      context: ./ # Caminho para o backend
    ports:
      - "8080:8080"
    networks:
      - app-network
    depends_on:
      - db

  frontend:
    build:
      context: ./frontend # Caminho para o frontend
    ports:
      - "3000:3000"
    networks:
      - app-network
    depends_on:
      - backend

  db:
    image: postgres:15
    restart: always
    environment:
      POSTGRES_USER: admin
      POSTGRES_PASSWORD: admin
      POSTGRES_DB: gerenciamento_tarefas
    ports:
      - "5432:5432"
    networks:
      - app-network

networks:
  app-network:
    driver: bridge
```

Execute o sistema:
```bash
docker-compose up --build
```
