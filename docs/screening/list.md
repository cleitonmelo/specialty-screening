### Lista os Formulários de Triagem Criados

Permite a listagem de todos os formulários criados no sistema

- **Método:** `GET`
- **Ponto de acesso:** `api/v1/screening`
- **Código HTTP:** `200 Ok`

#### Parâmetros
| **Campo**    | **Tipo** | **Descrição**           | **Requerido** | **Enum**   |
|--------------|----------|-------------------------|---------------|------------|
| specialty_id | Number   | Código da Especialidade | Não           |            |

```shell
curl --location 'http://localhost:8080/api/v1/screening?specialty_id=3' \
--data ''
```
    GET  api/v1/screening

#### Exemplo de resposta

##### Sucesso

```json
{
  "content": [
    {
      "id": 36,
      "patientCode": "53631826028",
      "patientName": "Antonio João da Silva",
      "specialty": {
        "id": 6,
        "name": "Pneumologista"
      },
      "status": "Aguardando o Especialista",
      "specialistDoctor": null,
      "teleCall": null,
      "medicalExams": null,
      "diagnosis": null
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
  "totalElements": 1,
  "totalPages": 1,
  "first": true,
  "size": 10,
  "number": 0,
  "sort": {
    "empty": false,
    "unsorted": false,
    "sorted": true
  },
  "numberOfElements": 1,
  "empty": false
}
```

[< Voltar para o índice](../../readme.md)
