package br.com.hackaton.specialtyscreening.dto.mappers;

import br.com.hackaton.specialtyscreening.controller.resources.ScreeningResource;
import br.com.hackaton.specialtyscreening.dto.DiagnosisDTO;
import br.com.hackaton.specialtyscreening.dto.ScreeningDTO;
import br.com.hackaton.specialtyscreening.dto.SpecialistDoctorDTO;
import br.com.hackaton.specialtyscreening.dto.SpecialtyDTO;
import br.com.hackaton.specialtyscreening.model.Diagnosis;
import br.com.hackaton.specialtyscreening.model.Screening;
import br.com.hackaton.specialtyscreening.model.SpecialistDoctor;
import br.com.hackaton.specialtyscreening.model.Specialty;
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
}
