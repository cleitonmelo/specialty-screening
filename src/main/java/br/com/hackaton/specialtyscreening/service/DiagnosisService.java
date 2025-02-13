package br.com.hackaton.specialtyscreening.service;

import br.com.hackaton.specialtyscreening.dto.DiagnosisDTO;
import br.com.hackaton.specialtyscreening.model.Diagnosis;

public interface DiagnosisService extends BaseService{

    Diagnosis create(DiagnosisDTO dto);

}
