package br.com.hackaton.specialtyscreening.dto.mappers;

import br.com.hackaton.specialtyscreening.dto.MedicalExamDTO;
import br.com.hackaton.specialtyscreening.model.MedicalExam;
import lombok.Builder;

@Builder
public class MedicalExamMapper implements BaseMapper {
    private MedicalExamMapper() {throw new IllegalStateException("Utility class");}

    public static MedicalExamDTO toDto(MedicalExam medicalExam) {
        return MedicalExamDTO.builder()
                .id(medicalExam.getId())
                .status(medicalExam.getStatus())
                .result(medicalExam.getResult())
                .build();
    }
    public static MedicalExam toEntity(MedicalExamDTO medicalExamDTO) {
        return MedicalExam.builder()
                .id(medicalExamDTO.id())
                .status(medicalExamDTO.status())
                .result(medicalExamDTO.result())
                .build();
    }
}
