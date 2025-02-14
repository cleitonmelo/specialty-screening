### Lista as Especialidades Cadastradas

Permite a listagem de todas as especialidades cadastradas

- **Método:** `GET`
- **Ponto de acesso:** `api/v1/specialty`
- **Código HTTP:** `200 Ok`

```shell
curl --location 'http://localhost:8080/api/v1/specialty' \
--data ''
```
    GET  api/v1/specialty

#### Exemplo de resposta

##### Sucesso

```json
{
  "content": [
    {
      "id": 1,
      "name": "Ortopedia"
    },
    {
      "id": 2,
      "name": "Otorrino"
    },
    {
      "id": 3,
      "name": "Ortodontia"
    },
    {
      "id": 4,
      "name": "Psicologo"
    },
    {
      "id": 5,
      "name": "Cardiologista"
    }
  ],
  "pageable": {
    "pageNumber": 0,
    "pageSize": 10,
    "sort": {
      "empty": false,
      "unsorted": false,
      "sorted": true
    },
    "offset": 0,
    "unpaged": false,
    "paged": true
  },
  "last": true,
  "totalElements": 5,
  "totalPages": 1,
  "first": true,
  "size": 10,
  "number": 0,
  "sort": {
    "empty": false,
    "unsorted": false,
    "sorted": true
  },
  "numberOfElements": 5,
  "empty": false
}
```

[< Voltar para o índice](../../readme.md)
