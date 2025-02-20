package br.com.hackaton.specialtyscreening.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record TelecallDTO(
        Long id,
        LocalDateTime initialDateTime,
        LocalDateTime finalDateTime,
        String status,
        String description
) implements BaseDto{
}
