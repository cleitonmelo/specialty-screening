### Lista os Exames Criados

Permite a listagem de todos os Exames criados no sistema

- **Método:** `GET`
- **Ponto de acesso:** `api/v1/exam`
- **Código HTTP:** `200 Ok`

```shell
curl --location 'http://localhost:8080/api/v1/exam' \
--data ''
```
    GET  api/v1/exam

#### Exemplo de resposta

##### Sucesso

```json
{
  "content": [
    {
      "id": 1,
      "examName": "Exame de Sangue",
      "examDescription": "Exame de amostra de sangue para avaliar a saúde do paciente"
    },
    {
      "id": 2,
      "examName": "Exame de Sangue2",
      "examDescription": "Exame para coleta e analise se Sangue"
    },
    {
      "id": 3,
      "examName": "Exame de sangue 3",
      "examDescription": "Detalhe sobre exame de sangue 3"
    }
  ],
  "pageable": {
    "pageNumber": 0,
    "pageSize": 10,
    "sort": {
      "empty": true,
      "unsorted": true,
      "sorted": false
    },
    "offset": 0,
    "unpaged": false,
    "paged": true
  },
  "last": true,
  "totalElements": 3,
  "totalPages": 1,
  "size": 10,
  "number": 0,
  "sort": {
    "empty": true,
    "unsorted": true,
    "sorted": false
  },
  "first": true,
  "numberOfElements": 3,
  "empty": false
}
```

[< Voltar para o índice](../../readme.md)
