package br.com.hackaton.specialtyscreening.dto;

import br.com.hackaton.specialtyscreening.enums.DiagnosisStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;


@Builder
public record DiagnosisDTO(
        @NotNull(message = "Identificação do paciente não pode ser nula.")
        DiagnosisStatus status,
        @NotNull(message = "Necessário selecionar especialidade.")
        String description
)  implements BaseDto {
}
