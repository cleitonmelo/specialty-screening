### Criar uma telechamada

Recebe os dados para a criação de uma telechamada

- **Método:** `PUT`
- **Ponto de acesso:** `api/v1/screening/{id}/telecall/start`
- **Código HTTP:** `201 CREATED`


#### Parâmetros
| **Campo**       | **Tipo** | **Descrição**                       | **Requerido** |
|-----------------|----------|-------------------------------------|---------------|
| id        | Long   | Identificação formulário de triagem | Sim           |
| uuid | UUID   | Identificação da telechamada        | Sim           |


```shell
curl --location 'http://localhost:8080/api/v1/screening/{id}/telecall/start' \
--header 'Content-Type: application/json' \
--data '{
}'
```
    PUT  api/v1/screening/{id}/telecall/start

#### Exemplo de resposta de sucesso

```json
{
  "uuid": "49dbc54d-a324-4588-85c5-72e2d177438b",
  "initialDateTime": "2025-02-22T19:15:15.973188351",
  "finalDateTime": null
}
```

[< Voltar para o índice](../../README.md)
