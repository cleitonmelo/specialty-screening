### Criar uma telechamada

Recebe os dados para a criação de uma telechamada

- **Método:** `PUT`
- **Ponto de acesso:** `api/v1/screening/{id}/telecall/stop`
- **Código HTTP:** `201 CREATED`

#### Parâmetros
| **Campo**       | **Tipo** | **Descrição**                       | **Requerido** |
|-----------------|----------|-------------------------------------|---------------|
| id        | Long   | Identificação formulário de triagem | Sim           |
| uuid | UUID   | Identificação da telechamada        | Sim           |


```shell
curl --location 'http://localhost:8080/api/v1/screening/{id}/telecall/stop' \
--header 'Content-Type: application/json' \
--data '{
}'
```
    PUT  api/v1/screening/{id}/telecall/stop

#### Exemplo de resposta de sucesso

```json
{
  "uuid": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
  "initialDateTime": "2025-02-22T22:15:28.772Z",
  "finalDateTime": "2025-02-22T22:15:28.772Z"
}
```

[< Voltar para o índice](../../README.md)
