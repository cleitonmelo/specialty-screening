package br.com.hackaton.specialtyscreening.dto.mappers;

import br.com.hackaton.specialtyscreening.dto.SpecialistDoctorDTO;
import br.com.hackaton.specialtyscreening.model.SpecialistDoctor;

public class SpecialistDoctorMapper {

    private SpecialistDoctorMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static SpecialistDoctorDTO toDto(SpecialistDoctor specialistDoctor) {
      return SpecialistDoctorDTO.builder()
              .id(specialistDoctor.getId())
              .name(specialistDoctor.getName())
              .specialties(specialistDoctor
                      .getSpecialties()
                      .stream()
                      .map(SpecialtyMapper::toDto).toList())
              .build();
    }

    public static SpecialistDoctor toEntity(SpecialistDoctorDTO dto) {
        return SpecialistDoctor.builder()
                .id(dto.id())
                .name(dto.name())
                .specialties(dto.specialties()
                        .stream()
                        .map(SpecialtyMapper::toEntity).toList())
                .build();
    }
}
