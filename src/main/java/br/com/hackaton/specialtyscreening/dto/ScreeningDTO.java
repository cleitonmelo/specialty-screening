package br.com.hackaton.specialtyscreening.dto;

import br.com.hackaton.specialtyscreening.enums.ScreeningStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Setter;


@Builder
public record ScreeningDTO(
        @Schema(hidden = true)
        Long id,
        @NotNull(message = "Identificação do paciente não pode ser nula.")
        String patientCode,
        @Schema(hidden = true)
        @Setter
        String patientName,
        @NotNull(message = "Necessário selecionar especialidade.")
        Long specialty,
        @Schema(hidden = true)
        SpecialistDoctorDTO specialistDoctor,
        @Schema(hidden = true)
        ScreeningStatus status,
        @Schema(hidden = true)
        DiagnosisDTO diagnosisDTO
)  implements BaseDto {
}
