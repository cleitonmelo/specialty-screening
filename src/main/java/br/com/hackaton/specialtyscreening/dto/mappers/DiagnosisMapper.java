package br.com.hackaton.specialtyscreening.dto.mappers;

import br.com.hackaton.specialtyscreening.controller.resources.DiagnosisResource;
import br.com.hackaton.specialtyscreening.dto.DiagnosisDTO;
import br.com.hackaton.specialtyscreening.model.Diagnosis;
import lombok.Builder;


@Builder
public class DiagnosisMapper implements BaseMapper {

    private DiagnosisMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static DiagnosisDTO toDto(Diagnosis diagnosis) {
      return DiagnosisDTO.builder()
              .description(diagnosis.getDescription())
              .status(diagnosis.getStatus())
              .build();
    }

    public static Diagnosis toEntity(DiagnosisDTO dto) {
        return Diagnosis.builder()
                .description(dto.description())
                .status(dto.status())
                .build();
    }

    public static DiagnosisResource toResource(DiagnosisDTO dto) {
        return DiagnosisResource.builder()
                .status(dto.status() != null ? DiagnosisStatusMapper.toDto(dto.status()) : null)
                .description(dto.description())
                .build();
    }
}
