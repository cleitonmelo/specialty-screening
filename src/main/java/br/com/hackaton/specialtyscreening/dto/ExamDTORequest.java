package br.com.hackaton.specialtyscreening.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ExamDTORequest {
    private String examName;
    private String examDescription;
}
