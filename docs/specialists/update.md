### Associar Especialista ao Formulário de Triagem

Inclui um especialista para analisar o formulário de triagem

- **Método:** `PUT`
- **Ponto de acesso:** `api/v1/specialists/{id}`
- **Código HTTP:** `200 OK`

#### Parâmetro

```shell
curl --location --request PUT 'http://localhost:8080/api/v1/specialists/5' \
--header 'Content-Type: application/json' \
--data '{
    "name": "Dra. Chavez",
    "specialties": [
            {
            "id": 3,
            "name": "Ortodontia"
            },
            {
            "id": 2,
            "name": "Otorrino"
            },
            {
            "id": 5
            }
  ]
}'
```
    PUT  api/v1/specialists/{id}

#### Exemplo de resposta de sucesso

```json
{
  "id": 5,
  "name": "Dra. Chavez",
  "specialties": [
    {
      "id": 3,
      "name": "Ortodontia"
    },
    {
      "id": 2,
      "name": "Otorrino"
    },
    {
      "id": 5,
      "name": "Cardiologista"
    }
  ]
}
```
[< Voltar para o índice](../../README.md)
