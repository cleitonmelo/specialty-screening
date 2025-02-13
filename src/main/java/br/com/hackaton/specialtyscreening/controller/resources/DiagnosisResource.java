package br.com.hackaton.specialtyscreening.controller.resources;

import lombok.Builder;

@Builder
public record DiagnosisResource(
        String status,
        String statusHelp,
        String description
) implements BaseResource{
}
