### Visualizar informações de um exame específico

Permite a visualização detalhada de um Exame

- **Método:** `GET`
- **Ponto de acesso:** `api/v1/exam/{id}`
- **Código HTTP:** `200 Ok`

```shell
curl --location 'http://localhost:8080/api/v1/exam/1' \
--data ''
```

    GET  api/v1/exam/{id}

#### Exemplo de resposta

##### Sucesso

```json
{
  "id": 1,
  "examName": "Exame de Sangue",
  "examDescription": "Exame de amostra de sangue para avaliar a saúde do paciente"
}
```

[< Voltar para o índice](../../readme.md)
