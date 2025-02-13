package br.com.hackaton.specialtyscreening.controller.resources;

public record MedicalExamResource(
        Long id,
        String status,
        String resultado
)implements BaseResource {
}
