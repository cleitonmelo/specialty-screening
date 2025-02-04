package br.com.hackaton.specialtyscreening.dto.mappers;

import br.com.hackaton.specialtyscreening.controller.resources.ScreeningResource;
import br.com.hackaton.specialtyscreening.dto.ScreeningDTO;
import br.com.hackaton.specialtyscreening.dto.SpecialtyDTO;
import br.com.hackaton.specialtyscreening.model.Screening;
import br.com.hackaton.specialtyscreening.model.Specialty;
import lombok.Builder;


@Builder
public class ScreeningMapper {

    private ScreeningMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static ScreeningDTO toDto(Screening screening) {
      return ScreeningDTO.builder()
              .id(screening.getId())
              .patientCode(screening.getPatientCode())
              .specialty(screening.getSpecialty().getId())
              .status(screening.getStatus())
              .build();
    }

    public static Screening toEntity(ScreeningDTO dto, Specialty specialty) {
        return Screening.builder()
                .id(dto.id())
                .patientCode(dto.patientCode())
                .specialty(specialty)
                .status(dto.status())
                .build();
    }

    public static ScreeningResource toResource(ScreeningDTO dto, SpecialtyDTO specialtyDTO) {
        return ScreeningResource.builder()
                .id(dto.id())
                .patientCode(dto.patientCode())
                .patientName(dto.patientName())
                .specialty(specialtyDTO)
                .status(dto.status().getDescription())
                .build();
    }

    public static ScreeningResource toResourceByModel(Screening screening) {
        return ScreeningResource.builder()
                .id(screening.getId())
                .patientCode(screening.getPatientCode())
                .patientName(screening.getPatientName())
                .specialty(SpecialtyMapper.toDto(screening.getSpecialty()))
                .specialistDoctor(screening.getSpecialistDoctor() != null ?
                        SpecialistDoctorMapper.toDto(screening.getSpecialistDoctor()) : null)
                .status(screening.getStatus().getDescription())
                .build();

    }
}
