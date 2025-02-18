package br.com.hackaton.specialtyscreening.dto.mappers;

import br.com.hackaton.specialtyscreening.dto.DiagnosisStatusDTO;
import br.com.hackaton.specialtyscreening.enums.DiagnosisStatus;
import lombok.Builder;


@Builder
public class DiagnosisStatusMapper implements BaseMapper {

    private DiagnosisStatusMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static DiagnosisStatusDTO toDto(DiagnosisStatus diagnosisStatus) {
      return DiagnosisStatusDTO.builder()
              .id(diagnosisStatus.name())
              .name(diagnosisStatus.getStatus())
              .meaning(diagnosisStatus.getDescription())
              .build();
    }
}
