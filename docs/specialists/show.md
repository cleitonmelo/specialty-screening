### Visualizar informações do Especialista

Permite a visualização detalhada de um Especialista

- **Método:** `GET`
- **Ponto de acesso:** `api/v1/specialists/{id}`
- **Código HTTP:** `200 Ok`

```shell
curl --location 'http://localhost:8080/api/v1/specialists/5' \
--data ''
```

    GET  api/v1/specialists/{id}

#### Exemplo de resposta

##### Sucesso

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
    }
  ]
}
```

[< Voltar para o índice](../../readme.md)
