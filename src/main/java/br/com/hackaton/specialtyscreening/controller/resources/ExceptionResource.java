package br.com.hackaton.specialtyscreening.controller.resources;

import lombok.Builder;

@Builder
public record ExceptionResource(
        String error,
        String message
) implements BaseResource{
}
