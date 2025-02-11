package br.com.hackaton.specialtyscreening.dto;

import br.com.hackaton.specialtyscreening.enums.ScreeningStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;


@Builder
public record ScreeningDTO(
        Long id,
        @NotNull(message = "Identificação do paciente não pode ser nula.")
        Long patientCode,
        String patientName,
        @NotNull(message = "Necessário selecionar especialidade.")
        Long specialty,
        Long specialistDoctor,
        ScreeningStatus status
)  implements BaseDto {
}
