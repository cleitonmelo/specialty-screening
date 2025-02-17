package br.com.hackaton.specialtyscreening.controller.resources;

import br.com.hackaton.specialtyscreening.dto.SpecialistDoctorDTO;
import br.com.hackaton.specialtyscreening.dto.SpecialtyDTO;
import br.com.hackaton.specialtyscreening.model.Exam;
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
        String teleCall,
        List<Exam> medicalExams,
        DiagnosisResource diagnosis
) implements BaseResource{
}
