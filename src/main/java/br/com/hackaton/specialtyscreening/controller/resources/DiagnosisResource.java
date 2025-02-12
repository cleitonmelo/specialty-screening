package br.com.hackaton.specialtyscreening.controller.resources;

import lombok.Builder;

import java.util.UUID;

@Builder
public record DiagnosisResource(
        String status,
        String statusHelp,
        String description
) implements BaseResource{
}
