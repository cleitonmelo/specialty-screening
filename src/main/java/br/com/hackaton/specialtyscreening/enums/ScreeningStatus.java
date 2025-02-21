package br.com.hackaton.specialtyscreening.enums;

import lombok.Getter;

@Getter
public enum ScreeningStatus {

    AWATING_SPECIALIST(0, "Aguardando o Especialista"),
    IN_ANALYSIS(1, "Em Análise"),
    AWAITING_EXAMS(2, "Aguardando Exames"),
    COMPLETED_EXAMS(3, "Exames Concluídos"),
    AWAITING_TELECALL(4, "Aguardando Tele Chamada"),
    STARTED_TELECALL(5, "Iniciou a Tele Chamada"),
    FINISHED_TELECALL(6, "Tele Chamada Concluída"),
    COMPLETED_DIAGNOSIS(7, "Diagnóstico Concluído");

    private int code;

    private String description;

    ScreeningStatus(int code, String status) {
        this.code = code;
        this.description = status;
    }
}
