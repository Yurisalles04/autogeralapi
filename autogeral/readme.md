Listar todos os produtos

URL: /produtos
Método HTTP: GET

Parâmetros de consulta: N/A
Corpo da solicitação: N/A
Exemplo de solicitação:
http

GET /produtos
Exemplo de resposta:
json

[
  {
    "id": 1,
    "nome": "Pneu",
    "valor": 200.0
  },
  {
    "id": 2,
    "nome": "Óleo de Motor",
    "valor": 50.0
  }
]
Códigos de status possíveis: 200 (OK)
Obter um produto específico
URL: /produtos/{id}
Método HTTP: GET
Parâmetros de consulta: N/A
Corpo da solicitação: N/A
Exemplo de solicitação:
http

GET /produtos/1
Exemplo de resposta:
json

{
  "id": 1,
  "nome": "Pneu",
  "valor": 200.0
}
Códigos de status possíveis: 200 (OK), 404 (Not Found)
Adicionar um novo produto
URL: /produtos
Método HTTP: POST
Parâmetros de consulta: N/A
Corpo da solicitação:
json

{
  "nome": "Bateria",
  "valor": 150.0
}
Exemplo de solicitação:
http

POST /produtos
Content-Type: application/json

{
  "nome": "Bateria",
  "valor": 150.0
}
Exemplo de resposta:
json

{
  "id": 3,
  "nome": "Bateria",
  "valor": 150.0
}
Códigos de status possíveis: 201 (Created), 400 (Bad Request)
Atualizar um produto existente
URL: /produtos/{id}
Método HTTP: PUT
Parâmetros de consulta: N/A
Corpo da solicitação:
json

{
  "nome": "Pneu Novo",
  "valor": 220.0
}
Exemplo de solicitação:
http

PUT /produtos/1
Content-Type: application/json

{
  "nome": "Pneu Novo",
  "valor": 220.0
}

Exemplo de resposta: N/A
Códigos de status possíveis: 200 (OK), 404 (Not Found), 400 (Bad Request)
Excluir um produto
URL: /produtos/{id}
Método HTTP: DELETE
Parâmetros de consulta: N/A
Corpo da solicitação: N/A
Exemplo de solicitação:
http


DELETE /produtos/1
Exemplo de resposta: N/A
Códigos de status possíveis: 204 (No Content), 404 (Not Found)