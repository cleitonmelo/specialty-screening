package br.com.hackaton.specialtyscreening.service.impl;

import br.com.hackaton.specialtyscreening.config.AppServicePatient;
import br.com.hackaton.specialtyscreening.dto.PatientDto;
import br.com.hackaton.specialtyscreening.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PatientServiceImpl implements PatientService {

    private final AppServicePatient appServicePatient;

    public PatientServiceImpl(AppServicePatient appServicePatient) {
        this.appServicePatient = appServicePatient;
    }

    @Override
    public PatientDto getPatientInfo(String patientCode) {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<PatientDto> response = restTemplate.getForEntity(
                appServicePatient.getUrl() + "/patient/cpf?cpf={id}",
                PatientDto.class,
                patientCode);

        if ( response.getStatusCode().is2xxSuccessful() ) {
            return response.getBody();
        }

        if ( response.getStatusCode() == HttpStatus.NOT_FOUND ) {
            return null;
        }

        return null;
    }
}
