package br.com.hackaton.specialtyscreening.dto.mappers;

import br.com.hackaton.specialtyscreening.dto.TeleCallDTO;
import br.com.hackaton.specialtyscreening.model.TeleCall;

public class TeleCallMapper {
    public static TeleCallDTO toDTO(TeleCall telecallModel) {
        return TeleCallDTO.builder()
                .uuid(telecallModel.getId())
                .initialDateTime(telecallModel.getInitialDateTime())
                .finalDateTime(telecallModel.getFinalDateTime())
                .build();
    }

    public static TeleCall toEntity(TeleCallDTO telecallDTO) {
        return TeleCall.builder()
                .id(telecallDTO.uuid())
                .initialDateTime(telecallDTO.initialDateTime())
                .finalDateTime(telecallDTO.finalDateTime())
                .build();
    }
}
