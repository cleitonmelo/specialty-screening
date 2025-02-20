package br.com.hackaton.specialtyscreening.controller.resources;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record TelecallResource(
        Long id,
        LocalDateTime initialDateTime,
        LocalDateTime finalDateTime,
        String status,
        String description
) implements BaseResource{
}
