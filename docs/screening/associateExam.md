### Associar Exame ao Formulário de Triagem

Inclui um exame para o formulário de triagem

- **Método:** `PUT`
- **Ponto de acesso:** `api/v1/screening/{id}/associateExam/{examId}`
- **Código HTTP:** `200 OK`

#### Parâmetro

```shell
curl --location --request PUT 'http://localhost:8080/api/v1/screening/1/associateExam/1' \
--data ''
```
    PUT  api/v1/screening/{id}/associateExam/{examId}

#### Exemplo de resposta de sucesso

```json
{
  "id": 1,
  "patientCode": "67bc6040f6170e620da5ea30",
  "patientName": null,
  "specialty": {
    "id": 1,
    "name": "Medico Geral"
  },
  "status": "Aguardando Exames",
  "specialistDoctor": null,
  "teleCall": null,
  "medicalExams": [
    {
      "id": 1,
      "examName": "Exame de Sangue",
      "examDescription": "Exame para coleta e analise se Sangue"
    }
  ],
  "diagnosis": null
}
```
[< Voltar para o índice](../../README.md)
