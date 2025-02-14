### Lista os Formulários de Triagem Criados

Permite a listagem de todos os formulários criados no sistema

- **Método:** `GET`
- **Ponto de acesso:** `api/v1/specialists`
- **Código HTTP:** `200 Ok`

```shell
curl --location 'http://localhost:8080/api/v1/specialists' \
--data ''
```
    GET  api/v1/specialists

#### Exemplo de resposta

##### Sucesso

```json
{
  "content": [
    {
      "id": 1,
      "name": "Dra. Kelly",
      "specialties": [
        {
          "id": 1,
          "name": "Ortopedia"
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
          "id": 2,
          "name": "Otorrino"
        }
      ]
    },
    {
      "id": 2,
      "name": "Dra. Kelly",
      "specialties": [
        {
          "id": 1,
          "name": "Ortopedia"
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
          "id": 2,
          "name": "Otorrino"
        }
      ]
    },
    {
      "id": 3,
      "name": "Dra. Adriano",
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
    },
    {
      "id": 4,
      "name": "Dr. Vando",
      "specialties": [
        {
          "id": 1,
          "name": "Ortopedia"
        },
        {
          "id": 3,
          "name": "Ortodontia"
        },
        {
          "id": 5,
          "name": "Cardiologista"
        }
      ]
    },
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
