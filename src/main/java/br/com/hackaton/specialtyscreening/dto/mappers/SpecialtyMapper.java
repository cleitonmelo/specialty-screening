package br.com.hackaton.specialtyscreening.dto.mappers;

import br.com.hackaton.specialtyscreening.dto.SpecialtyDTO;
import br.com.hackaton.specialtyscreening.model.Specialty;

public class SpecialtyMapper {

    private SpecialtyMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static SpecialtyDTO toDto(Specialty specialty) {
      return SpecialtyDTO.builder()
              .id(specialty.getId())
              .name(specialty.getName()).build();
    }

    public static Specialty toEntity(SpecialtyDTO dto) {
        return Specialty.builder()
                .id(dto.id())
                .name(dto.name())
                .build();
    }
}
