package br.com.hackaton.specialtyscreening.controller.resources;

import br.com.hackaton.specialtyscreening.dto.SpecialtyDTO;
import lombok.Builder;

import java.util.List;

@Builder
public record SpecialistDoctorResource(
        Long id,
        String name,
        List<SpecialtyDTO> specialties
) implements BaseResource{
}
