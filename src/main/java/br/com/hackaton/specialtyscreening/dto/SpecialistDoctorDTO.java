package br.com.hackaton.specialtyscreening.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record SpecialistDoctorDTO(
        Long id,
        String name,
        List<SpecialtyDTO> specialties
) {
}
