package br.com.hackaton.specialtyscreening.service;

import br.com.hackaton.specialtyscreening.dto.PatientDto;

public interface PatientService {

    PatientDto getPatientInfo(String patientCode);
}
