package br.com.hackaton.specialtyscreening.controller.resources;

import lombok.Builder;

@Builder
public record TelecallResource(
        Long id,
        String patientCode,
        String patientName
) implements BaseResource{
}
