### Associar Especialista ao Formulário de Triagem

Inclui um especialista para analisar o formulário de triagem

- **Método:** `PUT`
- **Ponto de acesso:** `api/v1/screening/{id}/associateSpecialists/{specialistId}`
- **Código HTTP:** `200 OK`

#### Parâmetro

```shell
curl --location --request PUT 'http://localhost:8080/api/v1/screening/35/associateSpecialists/1' \
--data ''
```
    PUT  api/v1/screening/{id}/associateSpecialists/{specialistId}

#### Exemplo de resposta de sucesso

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
[< Voltar para o índice](../../README.md)
