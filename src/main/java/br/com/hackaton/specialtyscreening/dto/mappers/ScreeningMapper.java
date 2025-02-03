package br.com.hackaton.specialtyscreening.dto.mappers;

import br.com.hackaton.specialtyscreening.controller.resources.ScreeningResource;
import br.com.hackaton.specialtyscreening.dto.ScreeningDTO;
import br.com.hackaton.specialtyscreening.enums.ScreeningStatus;
import br.com.hackaton.specialtyscreening.model.Screening;
import lombok.Builder;


@Builder
public class ScreeningMapper {

    public static ScreeningDTO toDto(Screening screening) {
      return ScreeningDTO.builder()
              .id(screening.getId())
              .patientCode(screening.getPatientCode())
              .specialtyCode(screening.getSpecialtyCode())
              .status(screening.getStatus())
              .build();
    }

    public static Screening toEntity(ScreeningDTO dto) {
        return Screening.builder()
                .id(dto.id())
                .patientCode(dto.patientCode())
                .specialtyCode(dto.specialtyCode())
                .status(dto.status())
                .build();
    }

    public static ScreeningResource toResource(ScreeningDTO dto) {
        return ScreeningResource.builder()
                .id(dto.id())
                .specialtyCode(dto.specialtyCode())
                .status(dto.status().getDescription())
                .build();
    }
}
