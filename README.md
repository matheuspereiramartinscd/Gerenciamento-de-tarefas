
# Sistema de Gerenciamento de Tarefas

Este projeto visa auxiliar equipes na organização e acompanhamento de tarefas. Com funcionalidades intuitivas, o sistema melhora a eficiência no gerenciamento de projetos e proporciona maior colaboração entre os membros da equipe.

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

    git clone https://github.com/seuusuario/sgte-backend.git
    cd sgte-backend


#### Configure o banco de dados PostgreSQL:

Crie um banco de dados chamado `gerenciamento_tarefas` com o usuário `admin` e senha `admin`.

    CREATE DATABASE gerenciamento_tarefas;

Configure o arquivo `application.properties`:

    properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/gerenciamento_tarefas
    spring.datasource.username=admin
    spring.datasource.password=admin
    spring.jpa.hibernate.ddl-auto=update
    

Compile e execute:

    mvn clean install
    mvn spring-boot:run
 

### 2. Frontend (React.js)
Clone o repositório:

    git clone https://github.com/seuusuario/sgte-frontend.git
    cd sgte-frontend
  

Instale as dependências:
 
    npm install
 

Execute o servidor de desenvolvimento:
  
    npm start


### 3. Docker
Certifique-se de que o Docker esteja instalado e configurado. Utilize o arquivo `docker-compose.yml` abaixo para rodar todo o sistema:
    yaml
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
 
Execute o sistema:
    
    docker-compose up --build
    
![lista](https://github.com/user-attachments/assets/c90c9cca-d104-4394-816e-ce0eef169d91)
![lissta](https://github.com/user-attachments/assets/08ad6437-4bb0-4f05-9b14-f9d79803db56)
![detalhes](https://github.com/user-attachments/assets/4e63019b-284e-42ae-b9ad-560a62f7b3fc)
![novatarefa](https://github.com/user-attachments/assets/83c58f50-5e2e-45ab-998a-9a63afebfd64)


