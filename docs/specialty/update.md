### Atualizar uma Especialidade

Atualizar uma especialidade

- **Método:** `PUT`
- **Ponto de acesso:** `api/v1/specialty/{id}`
- **Código HTTP:** `200 OK`

#### Parâmetro

```shell
curl --location --request PUT 'http://localhost:8080/api/v1/specialty/7' \
--header 'Content-Type: application/json' \
--data '{
    "name" : "Otorrinorolingologista"
}'
```
    PUT  api/v1/specialty/{id}

#### Exemplo de resposta de sucesso

```json
{
  "id": 7,
  "name": "Otorrinorolingologista"
}
```
[< Voltar para o índice](../../README.md)
