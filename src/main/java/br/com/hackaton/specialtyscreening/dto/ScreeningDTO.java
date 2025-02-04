package br.com.hackaton.specialtyscreening.dto;

import br.com.hackaton.specialtyscreening.enums.ScreeningStatus;
import lombok.Builder;


@Builder
public record ScreeningDTO(
        Long id,
        Long patientCode,
        String patientName,
        Long specialty,
        ScreeningStatus status
) {
}
