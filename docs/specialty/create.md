### Criar uma Especialidade

Recebe os dados para a criação de uma Especialidade

- **Método:** `POST`
- **Ponto de acesso:** `api/v1/specialty`
- **Código HTTP:** `201 CREATED`

#### Parâmetros
| **Campo** | **Tipo** | **Descrição**         | **Requerido** | **Enum**   |
|-----------|----------|-----------------------|---------------|------------|
| name      | String   | Nome da Especialidade | Sim           |            |

```shell
curl --location 'http://localhost:8080/api/v1/specialty' \
--header 'Content-Type: application/json' \
--data '{
    "name" : "Fisioterapeuta"
}'
```
    POST  api/v1/specialty

#### Exemplo de resposta de sucesso

```json
{
  "id": 7,
  "name": "Fisioterapeuta"
}
```

[< Voltar para o índice](../../README.md)
