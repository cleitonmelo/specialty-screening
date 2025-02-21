package br.com.hackaton.specialtyscreening.dto.mappers;

import br.com.hackaton.specialtyscreening.dto.ExamDTO;
import br.com.hackaton.specialtyscreening.model.Exam;

import java.util.ArrayList;
import java.util.List;

public class ExamMapper implements BaseMapper{


    private ExamMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static List<ExamDTO> toDto(List<Exam> examList) {
        List<ExamDTO> examDTO = new ArrayList<>();
        for (Exam exam : examList) {
            examDTO.add(toDto(exam));
        }
        return examDTO;
    }

    public static ExamDTO toDto(Exam exam) {
        return ExamDTO.builder()
                .id(exam.getId())
                .examName(exam.getExamName())
                .examDescription(exam.getExamDescription())
                .build();
    }

    public static Exam toEntity(ExamDTO examDTO) {
        return Exam.builder()
                .id(examDTO.id())
                .examName(examDTO.examName())
                .examDescription(examDTO.examDescription())
                .build();
    }
}
