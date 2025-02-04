package br.com.hackaton.specialtyscreening.dto;

import lombok.Builder;

@Builder
public record SpecialtyDTO(
        Long id,
        String name
) {
}
