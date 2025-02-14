### Criar um formulário de triagem

Recebe os dados para a criação de um formulário de triagem de especialidade

- **Método:** `POST`
- **Ponto de acesso:** `api/v1/screening`
- **Código HTTP:** `201 CREATED`

#### Parâmetros
| **Campo**   | **Tipo** | **Descrição**           | **Requerido** | **Enum**   |
|-------------|----------|-------------------------|---------------|------------|
| patientCode | String   | Código do Paciente      | Sim           |            |
| specialty   | Number   | Código da especialidade | Sim           | /specialty |


```shell
curl --location 'http://localhost:8080/api/v1/screening' \
--header 'Content-Type: application/json' \
--data '{
    "patientCode" : "53631826028",
    "specialty": 3
}'
```
    POST  api/v1/screening

#### Exemplo de resposta de sucesso

```json
{
  "id": 35,
  "patientCode": "53631826028",
  "patientName": "Antonio João da Silva",
  "specialty": {
    "id": 3,
    "name": "Ortodontia"
  },
  "status": "Aguardando o Especialista",
  "specialistDoctor": null,
  "teleCall": null,
  "medicalExams": null,
  "diagnosis": null
}
```

[< Voltar para o índice](../../README.md)
