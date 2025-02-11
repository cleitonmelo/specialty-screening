package br.com.hackaton.specialtyscreening.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.List;

@Builder
public record SpecialistDoctorDTO(
        Long id,
        @NotNull(message = "Nome do especialista não pode ser nulo.")
        String name,
        @NotEmpty(message = "Necessário selecionar ao menos uma especialidade.")
        List<SpecialtyDTO> specialties
) implements BaseDto{
}
