package br.com.hackaton.specialtyscreening.enums;

import lombok.Getter;

@Getter
public enum DiagnosisStatus {

    PRESUMPTIVE(0, "Presuntivo",
            "Baseado nos sintomas e histórico do paciente, mas ainda não confirmado por exames."),
    DEFINITIVE(1, "Definitivo",
            "Confirmado por exames laboratoriais, de imagem ou outros testes diagnósticos."),
    DIFFERENTIAL( 2, "Diferencial",
            "Possibilidades alternativas que precisam ser descartadas antes de chegar a um diagnóstico definitivo."),
    EXCLUSION( 3 , "Exclusão",
            "Quando o diagnóstico é feito eliminando outras condições possíveis."),
    PROVISIONAL( 4, "Provisório",
            "Um diagnóstico temporário até que mais informações sejam obtidas."),
    SYNDROMIC( 5, "Sindrômico",
            "Baseado em um conjunto de sinais e sintomas sem uma causa específica definida."),
    ETIOLOGIC( 6, "Etiológico",
            "Identifica a causa exata da doença."),
    FUNCTIONAL( 7, "Funcional",
            "Quando não há lesão orgânica evidente, mas há disfunção no organismo."),
    ANATOMICAL( 8, "Anatômico",
            "Quando o diagnóstico é baseado na localização da alteração no corpo.");

    private int code;

    private String status;

    private String description;

    DiagnosisStatus(int code, String status, String description) {
        this.code = code;
        this.status = status;
        this.description = description;
    }
}
