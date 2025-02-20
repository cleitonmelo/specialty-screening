### Criar uma telechamada

Recebe os dados para a criação de uma telechamada

- **Método:** `POST`
- **Ponto de acesso:** `api/v1/telecall`
- **Código HTTP:** `201 CREATED`

#### Parâmetros
| **Campo**    | **Tipo** | **Descrição**            | **Requerido** |
|--------------|----------|--------------------------|---------------|
| status       | String   | status da telechamada    | Sim           |
| description | String   | descrição da telachamada | Não           |


```shell
curl --location 'http://localhost:8080/api/v1/telecall' \
--header 'Content-Type: application/json' \
--data '{
    "status": "agendado",
    "description": "Telechamada de retorno"
}'
```
    POST  api/v1/telecall

#### Exemplo de resposta de sucesso

```json
{
  "id": 1,
  "status": "Agendado",
  "description": "Telechamada de retorno"
}
```

[< Voltar para o índice](../../README.md)
