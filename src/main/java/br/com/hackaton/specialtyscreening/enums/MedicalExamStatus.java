package br.com.hackaton.specialtyscreening.enums;

public enum MedicalExamStatus {
    // Status de Agendamento
    SCHEDULED("Scheduled"),
    PENDING_SCHEDULING("Pending Scheduling"),
    RESCHEDULED("Rescheduled"),
    CANCELLED("Cancelled"),

    // Status de Execução
    IN_PROGRESS("In Progress"),
    COMPLETED("Completed"),
    PARTIALLY_COMPLETED("Partially Completed"),
    NOT_PERFORMED("Not Performed"),

    // Status de Resultados
    PENDING_RESULTS("Pending Results"),
    RESULTS_AVAILABLE("Results Available"),
    REVIEWED("Reviewed"),
    NEEDS_REEVALUATION("Needs Re-evaluation"),
    INVALID("Invalid"),
    REJECTED("Rejected"),

    // Status Administrativos
    AUTHORIZED("Authorized"),
    NOT_AUTHORIZED("Not Authorized"),
    WAITING_FOR_APPROVAL("Waiting for Approval"),
    EXPIRED("Expired");

    private final String description;

    MedicalExamStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
