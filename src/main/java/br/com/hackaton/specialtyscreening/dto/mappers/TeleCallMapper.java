package br.com.hackaton.specialtyscreening.dto.mappers;

import br.com.hackaton.specialtyscreening.dto.TelecallDTO;
import br.com.hackaton.specialtyscreening.model.Telecall;

public class TeleCallMapper  implements BaseMapper{
    private TeleCallMapper() {
        throw new IllegalStateException("Utility class");
    }
    public static TelecallDTO toDTO(Telecall telecall) {
        return TelecallDTO
                .builder()
                .id(telecall.getId())
                .initialDateTime(telecall.getInitialDateTime())
                .finalDateTime(telecall.getFinalDateTime())
                .status(telecall.getStatus())
                .description(telecall.getDescription())
                .build();
    }
    public static Telecall toEntity(TelecallDTO telecallDTO) {
        return Telecall
                .builder()
                .id(telecallDTO.id())
                .initialDateTime(telecallDTO.initialDateTime())
                .finalDateTime(telecallDTO.finalDateTime())
                .status(telecallDTO.status())
                .description(telecallDTO.description())
                .build();
    }
}
