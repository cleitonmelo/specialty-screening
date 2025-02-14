package br.com.hackaton.specialtyscreening.service.impl;

import br.com.hackaton.specialtyscreening.config.AppServicePatient;
import br.com.hackaton.specialtyscreening.dto.PatientDTO;
import br.com.hackaton.specialtyscreening.service.PatientService;
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
    public PatientDTO getPatientInfo(String patientCode) {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<PatientDTO> response = restTemplate.getForEntity(
                appServicePatient.getUrl() + "/patient/cpf?cpf={id}",
                PatientDTO.class,
                patientCode);

        if ( response.getStatusCode().is2xxSuccessful() ) {
            return response.getBody();
        }

        return null;
    }
}
