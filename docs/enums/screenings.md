### Lista dos Status do Formulário de Triagem

Listar todos os status possíveis para um formulário de triagem

- **Método:** `GET`
- **Ponto de acesso:** `api/v1/status/screenings`
- **Código HTTP:** `200 Ok`

```shell
curl --location 'http://localhost:8080/api/v1/status/screenings'
```
    GET  api/v1/status/screenings

#### Exemplo de resposta

##### Sucesso

```json
[
  {
    "id": "0",
    "description": "Aguardando o Especialista"
  },
  {
    "id": "1",
    "description": "Em Análise"
  },
  {
    "id": "2",
    "description": "Aguardando Exames"
  },
  {
    "id": "3",
    "description": "Exames Concluídos"
  },
  {
    "id": "4",
    "description": "Aguardando Tele Chamada"
  },
  {
    "id": "5",
    "description": "Iniciou a Tele Chamada"
  },
  {
    "id": "6",
    "description": "Tele Chamada Concluída"
  },
  {
    "id": "7",
    "description": "Diagnóstico Concluído"
  }
]
```

[< Voltar para o índice](../../readme.md)
