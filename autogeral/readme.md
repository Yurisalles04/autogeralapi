Criação de Produto: Permite adicionar um novo produto automotivo ao sistema, fornecendo informações como nome e valor do produto.

Obtenção de Produto por ID: Permite recuperar informações detalhadas de um produto automotivo específico com base no seu ID único.

Atualização de Produto por ID: Permite modificar as informações de um produto automotivo existente, como o seu nome e valor.

Exclusão de Produto por ID: Permite remover um produto automotivo do sistema com base no seu ID único.

Benefícios:
Automatização do Gerenciamento de Produtos: Com essa API, as empresas podem automatizar tarefas de gerenciamento de produtos automotivos, reduzindo a necessidade de intervenção manual e aumentando a eficiência operacional.

Integração com Outros Sistemas: A API pode ser facilmente integrada a outros sistemas, como sistemas de comércio eletrônico ou sistemas de gestão empresarial (ERP), permitindo uma sincronização eficaz de dados.

Acesso Remoto aos Dados: Através dessa API, os desenvolvedores podem acessar e manipular os dados dos produtos automotivos de forma remota, o que possibilita a criação de aplicativos móveis, painéis administrativos e outros sistemas que dependem dessas informações.

Flexibilidade e Escalabilidade: A API é projetada para ser flexível e escalável, podendo lidar com um grande volume de solicitações de forma eficiente, adaptando-se às necessidades em constante mudança do negócio.

Segue abaixo como funcionará essa API: 
1. Criar Produto
URL: /produtos
Método: POST
Corpo:
json
Copy code
{
  "nome": "Nome do Produto",
  "valor": 10000.00
}
Exemplo de Solicitação:
http
Copy code
POST /produtos HTTP/1.1
Host: api.exemplo.com
Content-Type: application/json

{
  "nome": "Bateria de Carro",
  "valor": 150.00
}
Exemplo de Resposta:
json
Copy code
{
  "id": 1,
  "nome": "Bateria de Carro",
  "valor": 150.00
}
Códigos de Status Possíveis:
201 Criado: Produto criado com sucesso.
400 Solicitação Inválida: Formato de solicitação inválido ou parâmetros ausentes.
2. Obter Produto por ID
URL: /produtos/{id}
Método: GET
Parâmetros:
id (obrigatório): ID do produto a ser recuperado.
Exemplo de Solicitação:
http
Copy code
GET /produtos/1 HTTP/1.1
Host: api.exemplo.com
Exemplo de Resposta:
json
Copy code
{
  "id": 1,
  "nome": "Bateria de Carro",
  "valor": 150.00
}
Códigos de Status Possíveis:
200 OK: Detalhes do produto recuperados com sucesso.
404 Não Encontrado: Produto com o ID fornecido não encontrado.
3. Atualizar Produto por ID
URL: /produtos/{id}
Método: PUT
Parâmetros:
id (obrigatório): ID do produto a ser atualizado.
Corpo:
json
Copy code
{
  "nome": "Novo Nome do Produto",
  "valor": 12000.00
}
Exemplo de Solicitação:
http
Copy code
PUT /produtos/1 HTTP/1.1
Host: api.exemplo.com
Content-Type: application/json

{
  "nome": "Bateria de Carro Atualizada",
  "valor": 160.00
}
Exemplo de Resposta:
json
Copy code
{
  "id": 1,
  "nome": "Bateria de Carro Atualizada",
  "valor": 160.00
}
Códigos de Status Possíveis:
200 OK: Produto atualizado com sucesso.
400 Solicitação Inválida: Formato de solicitação inválido ou parâmetros ausentes.
404 Não Encontrado: Produto com o ID fornecido não encontrado.
4. Excluir Produto por ID
URL: /produtos/{id}
Método: DELETE
Parâmetros:
id (obrigatório): ID do produto a ser excluído.
Exemplo de Solicitação:
http
Copy code
DELETE /produtos/1 HTTP/1.1
Host: api.exemplo.com
Exemplo de Resposta:
json
Copy code
{
  "mensagem": "Produto excluído com sucesso."
}
Códigos de Status Possíveis:
200 OK: Produto excluído com sucesso.
404 Não Encontrado: Produto com o ID fornecido não encontrado.
