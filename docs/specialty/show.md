### Visualizar uma Especialidade

Permite a visualização detalhada de uma Especialidade

- **Método:** `GET`
- **Ponto de acesso:** `api/v1/specialty/{id}`
- **Código HTTP:** `200 Ok`

```shell
curl --location 'http://localhost:8080/api/v1/specialty/7' \
--data ''
```

    GET  api/v1/specialty/{id}

#### Exemplo de resposta

##### Sucesso

```json
{
  "id": 7,
  "name": "Fisioterapeuta"
}
```

[< Voltar para o índice](../../readme.md)
