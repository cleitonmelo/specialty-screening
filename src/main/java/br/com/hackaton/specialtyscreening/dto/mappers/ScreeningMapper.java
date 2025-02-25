package br.com.hackaton.specialtyscreening.dto.mappers;

import br.com.hackaton.specialtyscreening.controller.resources.ScreeningResource;
import br.com.hackaton.specialtyscreening.dto.ExamDTO;
import br.com.hackaton.specialtyscreening.dto.ScreeningDTO;
import br.com.hackaton.specialtyscreening.dto.SpecialistDoctorDTO;
import br.com.hackaton.specialtyscreening.dto.SpecialtyDTO;
import br.com.hackaton.specialtyscreening.model.*;
import lombok.Builder;


@Builder
public class ScreeningMapper implements BaseMapper {

    private ScreeningMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static ScreeningDTO toDto(Screening screening) {
      return ScreeningDTO.builder()
              .id(screening.getId())
              .patientCode(screening.getPatientCode())
              .patientName(screening.getPatientName())
              .specialty(screening.getSpecialty() != null && screening.getSpecialty().getId() != null ?
                      screening.getSpecialty().getId() : null)
              .specialistDoctor(screening.getSpecialistDoctor() != null ?
                      SpecialistDoctorMapper.toDto(screening.getSpecialistDoctor()) : null)
              .medicalExams(screening.getExam() != null?
                      ExamMapper.toDto(screening.getExam()) : null)
              .status(screening.getStatus())
              .diagnosisDTO(screening.getDiagnosis() != null ?
                      DiagnosisMapper.toDto(screening.getDiagnosis()) : null)
              .teleCallDTO(screening.getTeleCall() != null ?
                      TeleCallMapper.toDTO(screening.getTeleCall()) : null)
              .build();
    }

    public static Screening toEntity(ScreeningDTO dto,
                                     Specialty specialty) {
        return Screening.builder()
                .id(dto.id())
                .patientCode(dto.patientCode())
                .patientName(dto.patientName())
                .specialty(specialty)
                .specialistDoctor(dto.specialistDoctor() != null ?
                        SpecialistDoctorMapper.toEntity(dto.specialistDoctor()) : null)
                .exam(dto.medicalExams() != null ? dto.medicalExams()
                        .stream().map(ExamMapper::toEntity).toList() : null)
                .status(dto.status())
                .teleCall(dto.teleCallDTO() != null ? TeleCallMapper.toEntity(dto.teleCallDTO()) : null)
                .build();
    }

    public static Screening toEntityByDoctor(ScreeningDTO dto,
                                             Specialty specialty,
                                             SpecialistDoctor specialistDoctor) {
        return Screening.builder()
                .id(dto.id())
                .patientCode(dto.patientCode())
                .patientName(dto.patientName())
                .specialty(specialty)
                .specialistDoctor(specialistDoctor)
                .exam(dto.medicalExams() != null ? dto.medicalExams()
                        .stream().map(ExamMapper::toEntity).toList() : null)
                .status(dto.status())
                .diagnosis(dto.diagnosisDTO() != null ? DiagnosisMapper.toEntity(dto.diagnosisDTO()) : null)
                .teleCall(dto.teleCallDTO() != null ? TeleCallMapper.toEntity(dto.teleCallDTO()) : null)
                .build();
    }

    public static ScreeningResource toResource(ScreeningDTO dto,
                                               SpecialtyDTO specialtyDTO,
                                               SpecialistDoctorDTO specialistDoctorDTO) {
        return ScreeningResource.builder()
                .id(dto.id())
                .patientCode(dto.patientCode())
                .patientName(dto.patientName())
                .specialty(specialtyDTO)
                .specialistDoctor(specialistDoctorDTO)
                .status(dto.status().getDescription())
                .medicalExams(dto.medicalExams())
                .diagnosis(dto.diagnosisDTO() != null ? DiagnosisMapper.toResource(dto.diagnosisDTO()) : null)
                .teleCall(dto.teleCallDTO() != null ? dto.teleCallDTO() : null)
                .build();
    }

    public static ScreeningResource toResourceByModel(Screening screening) {
        return ScreeningResource.builder()
                .id(screening.getId())
                .patientCode(screening.getPatientCode())
                .patientName(screening.getPatientName())
                .specialty(SpecialtyMapper.toDto(screening.getSpecialty()))
                .specialistDoctor(screening.getSpecialistDoctor() != null ? SpecialistDoctorMapper.toDto(screening.getSpecialistDoctor()) : null)
                .status(screening.getStatus().getDescription())
                .teleCall(screening.getTeleCall() != null ? TeleCallMapper.toDTO(screening.getTeleCall()) : null)
                .medicalExams(screening.getExam() != null?
                        ExamMapper.toDto(screening.getExam()) : null)
                .diagnosis(screening.getDiagnosis() != null ?
                        DiagnosisMapper.toResource(DiagnosisMapper.toDto(screening.getDiagnosis())) : null)
                .teleCall(screening.getTeleCall() != null ?
                        TeleCallMapper.toDTO(screening.getTeleCall()) : null)
                .build();

    }
}
