package br.com.hackaton.specialtyscreening.controller.resources;

import br.com.hackaton.specialtyscreening.dto.ExamDTO;
import br.com.hackaton.specialtyscreening.dto.SpecialistDoctorDTO;
import br.com.hackaton.specialtyscreening.dto.SpecialtyDTO;
import br.com.hackaton.specialtyscreening.dto.TeleCallDTO;
import lombok.Builder;

import java.util.List;

@Builder
public record ScreeningResource(
        Long id,
        String patientCode,
        String patientName,
        SpecialtyDTO specialty,
        String status,
        SpecialistDoctorDTO specialistDoctor,
        List<ExamDTO> medicalExams,
        DiagnosisResource diagnosis,
        TeleCallDTO teleCall
) implements BaseResource{
}
