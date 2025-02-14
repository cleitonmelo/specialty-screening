package br.com.hackaton.specialtyscreening.controller.resources;

import br.com.hackaton.specialtyscreening.dto.DiagnosisStatusDTO;
import lombok.Builder;

@Builder
public record DiagnosisResource(
        DiagnosisStatusDTO status,
        String description
) implements BaseResource{
}
