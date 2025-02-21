### Lista dos Status do Diagnótico

Listar todos os status possíveis para um diagnóstico

- **Método:** `GET`
- **Ponto de acesso:** `api/v1/status/diagnosis`
- **Código HTTP:** `200 Ok`

```shell
curl --location 'http://localhost:8080/api/v1/status/diagnosis'
```
    GET  api/v1/status/diagnosis

#### Exemplo de resposta

##### Sucesso

```json
[
  {
    "id": "PRESUMPTIVE",
    "name": "Presuntivo",
    "meaning": "Baseado nos sintomas e histórico do paciente, mas ainda não confirmado por exames."
  },
  {
    "id": "DEFINITIVE",
    "name": "Definitivo",
    "meaning": "Confirmado por exames laboratoriais, de imagem ou outros testes diagnósticos."
  },
  {
    "id": "DIFFERENTIAL",
    "name": "Diferencial",
    "meaning": "Possibilidades alternativas que precisam ser descartadas antes de chegar a um diagnóstico definitivo."
  },
  {
    "id": "EXCLUSION",
    "name": "Exclusão",
    "meaning": "Quando o diagnóstico é feito eliminando outras condições possíveis."
  },
  {
    "id": "PROVISIONAL",
    "name": "Provisório",
    "meaning": "Um diagnóstico temporário até que mais informações sejam obtidas."
  },
  {
    "id": "SYNDROMIC",
    "name": "Sindrômico",
    "meaning": "Baseado em um conjunto de sinais e sintomas sem uma causa específica definida."
  },
  {
    "id": "ETIOLOGIC",
    "name": "Etiológico",
    "meaning": "Identifica a causa exata da doença."
  },
  {
    "id": "FUNCTIONAL",
    "name": "Funcional",
    "meaning": "Quando não há lesão orgânica evidente, mas há disfunção no organismo."
  },
  {
    "id": "ANATOMICAL",
    "name": "Anatômico",
    "meaning": "Quando o diagnóstico é baseado na localização da alteração no corpo."
  }
]
```

[< Voltar para o índice](../../readme.md)
