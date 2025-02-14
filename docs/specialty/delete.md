### Criar um formulário de triagem

Recebe os dados para a criação de um formulário de triagem de especialidade

- **Método:** `POST`
- **Ponto de acesso:** `api/v1/screening/{id}/diagnosis`
- **Código HTTP:** `200 OK`

#### Parâmetros
| **Campo**   | **Tipo** | **Descrição**                   | **Requerido** | **Enum**          |
|-------------|----------|---------------------------------|---------------|-------------------|
| status      | String   | Código do Status do Diagnostico | Sim           |                   |
| description | String   | Descrição Médica                | Sim           | /status/diagnosis |


```shell
curl --location 'http://localhost:8080/api/v1/screening/35/diagnosis' \
--header 'Content-Type: application/json' \
--data '{
  "status": "PRESUMPTIVE",
  "description": "Resumo da informação do médico"
}'
```
    POST  api/v1/screening/{id}/diagnosis

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
  "status": "Diagnótico Concluído",
  "specialistDoctor": {
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
  "teleCall": null,
  "medicalExams": null,
  "diagnosis": {
    "status": {
      "id": null,
      "name": "Presuntivo",
      "meaning": "Baseado nos sintomas e histórico do paciente, mas ainda não confirmado por exames."
    },
    "description": "string"
  }
}
```

[< Voltar para o índice](../../README.md)
