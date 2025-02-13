package br.com.hackaton.specialtyscreening.service;

import br.com.hackaton.specialtyscreening.dto.MedicalExamDTO;
import org.springframework.stereotype.Service;

@Service
public interface MedicalExamService extends BaseService {
    MedicalExamDTO create(MedicalExamDTO medicalExamDTO);

    MedicalExamDTO get(Long id);

    MedicalExamDTO update(MedicalExamDTO medicalExamDTO);
}
