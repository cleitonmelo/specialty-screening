### Criar um especialista

Recebe os dados para a criação de um especialista

- **Método:** `POST`
- **Ponto de acesso:** `api/v1/specialists`
- **Código HTTP:** `201 CREATED`

#### Parâmetros
| **Campo**   | **Tipo**                | **Descrição**           | **Requerido** | **Enum**   |
|-------------|-------------------------|-------------------------|---------------|------------|
| name        | String                  | Nome do Especialista    | Sim           |            |
| specialties | Lista de Especialidades | Código da especialidade | Sim           | /specialty |


```shell
curl --location 'http://localhost:8080/api/v1/specialists' \
--header 'Content-Type: application/json' \
--data '{
    "name" : "Dra. Chavez",
    "specialties": [
        {
            "id" : 2
        },
        {
            "id" : 3
        }
    ]
}'
```
    POST  api/v1/specialists

#### Exemplo de resposta de sucesso

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

[< Voltar para o índice](../../README.md)
