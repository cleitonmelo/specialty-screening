package br.com.hackaton.specialtyscreening.dto;

import lombok.Builder;

@Builder
public record TelecallDTO(
        Long id,
        String status,
        String description
) implements BaseDto{
}
