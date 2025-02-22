### Criar uma telechamada

Recebe os dados para a criação de uma telechamada

- **Método:** `POST`
- **Ponto de acesso:** `api/v1/screening/{id}/telecall`
- **Código HTTP:** `201 CREATED`

#### Parâmetros
| **Campo** | **Tipo** | **Descrição**       | **Requerido** |
|-----------|----------|---------------------|---------------|
| id        | Long     | Identificação formulário de triagem| sim           |


```shell
curl --location 'http://localhost:8080/api/v1/screening/{id}/telecall' \
--header 'Content-Type: application/json' \
--data '{
}'
```
    POST  api/v1/screening/{id}/telecall

#### Exemplo de resposta de sucesso

```json
{
  "uuid": "49dbc54d-a324-4588-85c5-72e2d177438b",
  "initialDateTime": null,
  "finalDateTime": null
}
```

[< Voltar para o índice](../../README.md)
