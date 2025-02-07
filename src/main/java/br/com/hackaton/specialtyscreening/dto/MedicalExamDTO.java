package br.com.hackaton.specialtyscreening.dto;

import br.com.hackaton.specialtyscreening.enums.ScreeningStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record MedicalExamDTO(
        Long id,
        @NotNull(message = "Identificação do exame não pode ser nula.")
        String status,
        @NotNull(message = "Deve se iniciar um com status inicial.")
        String result
) {

}
