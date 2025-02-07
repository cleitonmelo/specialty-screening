package br.com.hackaton.specialtyscreening.service.impl;

import br.com.hackaton.specialtyscreening.dto.MedicalExamDTO;
import br.com.hackaton.specialtyscreening.repository.MedicalExamRepository;
import br.com.hackaton.specialtyscreening.service.MedicalExamService;

public class MedicalExamServiceImpl implements MedicalExamService {
    private final MedicalExamRepository medicalExamRepository;

    public MedicalExamServiceImpl(MedicalExamRepository medicalExamRepository) {
        this.medicalExamRepository = medicalExamRepository;
    }

    @Override
    public MedicalExamDTO create(MedicalExamDTO medicalExamDTO) {
        return null;
    }

    @Override
    public MedicalExamDTO get(Long id) {
        return null;
    }

    @Override
    public MedicalExamDTO update(MedicalExamDTO medicalExamDTO) {
        return null;
    }
}
