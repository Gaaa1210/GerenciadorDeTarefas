# Task Management API

API para gerenciamento de usuários, categorias e tarefas.

## Endpoints

1. Criar Usuário
**POST**  
`http://localhost:8080/users`

**Body (JSON):**
{
  "email": "user@example.com",
  "name": "user"
}

2. Criar Categoria
POST
`http://localhost:8080/categories`

**Body (JSON):**
{
  "name": "Test Categorie"
}

3. Criar Tarefa
POST
`http://localhost:8080/tasks/1?categoryId=1`

**Body (JSON):**
{
  "title": "Estudos de Java",
  "description": "Estudar Spring Boot",
  "completed": false
}

4. Listar Tarefas
GET
`http://localhost:8080/tasks`

5. Concluir Tarefa
PATCH
`http://localhost:8080/tasks/1/complete`
