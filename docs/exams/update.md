### Atualizar um exame especifico

Atualiza informações de um exame específico

- **Método:** `PUT`
- **Ponto de acesso:** `api/v1/exam/{id}`
- **Código HTTP:** `200 OK`

#### Parâmetro

```shell
curl --location --request PUT 'http://localhost:8080/api/v1/exam/1' \
--header 'Content-Type: application/json' \
--data '{
  "examName": "Exame de Sangue",
  "examDescription": "Exame para coleta e analise se Sangue"
}'
```
    PUT  api/v1/exam/{id}

#### Exemplo de resposta de sucesso

```json
{
  "id": 1,
  "examName": "Exame de Sangue",
  "examDescription": "Exame para coleta e analise se Sangue"
}
```
[< Voltar para o índice](../../README.md)
