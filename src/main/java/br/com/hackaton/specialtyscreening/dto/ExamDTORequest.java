package br.com.hackaton.specialtyscreening.dto;

import lombok.Builder;

@Builder
public class ExamDTORequest {
    private String examName;
    private String examDescription;
    private boolean active;
}
