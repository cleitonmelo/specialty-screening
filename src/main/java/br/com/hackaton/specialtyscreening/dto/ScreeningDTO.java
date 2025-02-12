package br.com.hackaton.specialtyscreening.dto;

import br.com.hackaton.specialtyscreening.enums.ScreeningStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;


@Builder
public record ScreeningDTO(
        Long id,
        @NotNull(message = "Identificação do paciente não pode ser nula.")
        String patientCode,
        String patientName,
        @NotNull(message = "Necessário selecionar especialidade.")
        Long specialty,
        SpecialistDoctorDTO specialistDoctor,
        ScreeningStatus status,
        DiagnosisDTO diagnosisDTO
)  implements BaseDto {
}
