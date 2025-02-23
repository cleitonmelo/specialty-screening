package br.com.hackaton.specialtyscreening.dto.mappers;

import br.com.hackaton.specialtyscreening.controller.resources.TeleCallResource;
import br.com.hackaton.specialtyscreening.dto.TeleCallDTO;
import br.com.hackaton.specialtyscreening.model.TeleCall;

public class TeleCallMapper {
    public static TeleCallDTO toDTO(TeleCall teleCallModel) {
        return TeleCallDTO.builder()
                .uuid(teleCallModel.getId())
                .initialDateTime(teleCallModel.getInitialDateTime())
                .finalDateTime(teleCallModel.getFinalDateTime())
                .build();
    }

    public static TeleCall toEntity(TeleCallDTO teleCallDTO) {
        return TeleCall.builder()
                .id(teleCallDTO.uuid())
                .initialDateTime(teleCallDTO.initialDateTime())
                .finalDateTime(teleCallDTO.finalDateTime())
                .build();
    }
    public static TeleCallResource toResource(TeleCallDTO teleCallDTO) {
        return TeleCallResource
                .builder()
                .uuid(teleCallDTO.uuid())
                .initialDateTime(teleCallDTO.initialDateTime())
                .finalDateTime(teleCallDTO.finalDateTime())
                .build();
    }
}
