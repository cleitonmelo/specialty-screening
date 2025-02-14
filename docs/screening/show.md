### Viasulizar um Formulário de Triagem

Permite a visualização detalhada de um formulário de triagem

- **Método:** `GET`
- **Ponto de acesso:** `api/v1/screening/{id}`
- **Código HTTP:** `200 Ok`

```shell
curl --location 'http://localhost:8080/api/v1/screening/35' \
--data ''
```

    GET  api/v1/screening/{id}

#### Exemplo de resposta

##### Sucesso

```json
{
  "id": 35,
  "patientCode": "53631826028",
  "patientName": null,
  "specialty": {
    "id": 3,
    "name": "Ortodontia"
  },
  "status": "Em Análise",
  "specialistDoctor": {
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
  "teleCall": null,
  "medicalExams": null,
  "diagnosis": null
}
```

[< Voltar para o índice](../../readme.md)
