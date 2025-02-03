package br.com.hackaton.specialtyscreening.controller.resources;

import lombok.Builder;

@Builder
public record ScreeningResource(
        Long id,
        String specialtyCode,
        String status
) {
}
