package br.com.hackaton.specialtyscreening.controller.resources;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record TeleCallResource(
        UUID uuid,
        LocalDateTime initialDateTime,
        LocalDateTime finalDateTime
) {
}
