### Criar um exame

Recebe os dados para a criação de um exame

- **Método:** `POST`
- **Ponto de acesso:** `api/v1/exam`
- **Código HTTP:** `201 CREATED`

#### Parâmetros
| **Campo**       | **Tipo** | **Descrição**           | **Requerido** |
|-----------------|----------|-------------------------|---------------|
| examName        | String   | Nome do exame           | Sim           |
| examDescription | String   | Código da especialidade | Sim           |


```shell
curl --location 'http://localhost:8080/api/v1/exam' \
--header 'Content-Type: application/json' \
--data '{
    "examName": "Exame de Sangue",
    "examDescription": "Exame de amostra de sangue para avaliar a saúde do paciente"
}'
```
    POST  api/v1/exam

#### Exemplo de resposta de sucesso

```json
{
  "id": 1,
  "examName": "Exame de Sangue",
  "examDescription": "Exame de amostra de sangue para avaliar a saúde do paciente"
}
```

[< Voltar para o índice](../../README.md)
