package br.com.hackaton.specialtyscreening.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record ExamDTO(
        Long id,
        @NotNull(message = "Nome do exame não pode ser nulo.")
        String examName,
        String examDescription
) {
}
