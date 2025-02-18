package br.com.hackaton.specialtyscreening.dto;

import br.com.hackaton.specialtyscreening.enums.ScreeningStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import java.util.List;


@Builder
public record ScreeningDTO(
        @Schema(hidden = true)
        Long id,
        @NotNull(message = "Identificação do paciente não pode ser nula.")
        String patientCode,
        @Schema(hidden = true)
        String patientName,
        @NotNull(message = "Necessário selecionar especialidade.")
        Long specialty,
        @Schema(hidden = true)
        SpecialistDoctorDTO specialistDoctor,
        @Schema(hidden = true)
        List<ExamDTO> medicalExams,
        @Schema(hidden = true)
        ScreeningStatus status,
        @Schema(hidden = true)
        DiagnosisDTO diagnosisDTO
)  implements BaseDto {
}
