package br.com.hackaton.specialtyscreening.dto;

import lombok.Builder;

@Builder
public record ScreeningStatusDTO(
        String id,
        String description
) {
}
