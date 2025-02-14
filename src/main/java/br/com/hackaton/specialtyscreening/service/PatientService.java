package br.com.hackaton.specialtyscreening.service;

import br.com.hackaton.specialtyscreening.dto.PatientDTO;

public interface PatientService {

    PatientDTO getPatientInfo(String patientCode);
}
