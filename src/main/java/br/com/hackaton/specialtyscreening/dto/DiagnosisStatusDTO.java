package br.com.hackaton.specialtyscreening.dto;

import lombok.Builder;

@Builder
public record DiagnosisStatusDTO(
        String id,
        String name,
        String meaning
) {
}
