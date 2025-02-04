package br.com.hackaton.specialtyscreening.controller.resources;

import br.com.hackaton.specialtyscreening.dto.SpecialtyDTO;
import lombok.Builder;

import java.util.List;

@Builder
public record ScreeningResource(
        Long id,
        Long patientCode,
        String patientName,
        SpecialtyDTO specialty,
        String status,
        String specialistDoctor,
        List<Object> medicalExams
) {
}
