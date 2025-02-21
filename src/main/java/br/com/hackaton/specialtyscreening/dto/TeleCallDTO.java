package br.com.hackaton.specialtyscreening.dto;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record TeleCallDTO(
        UUID uuid,
        LocalDateTime initialDateTime,
        LocalDateTime finalDateTime) {
}
