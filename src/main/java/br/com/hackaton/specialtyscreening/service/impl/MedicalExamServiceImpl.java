package br.com.hackaton.specialtyscreening.service.impl;

import br.com.hackaton.specialtyscreening.dto.MedicalExamDTO;
import br.com.hackaton.specialtyscreening.dto.mappers.MedicalExamMapper;
import br.com.hackaton.specialtyscreening.model.MedicalExam;
import br.com.hackaton.specialtyscreening.repository.MedicalExamRepository;
import br.com.hackaton.specialtyscreening.service.MedicalExamService;
import org.springframework.stereotype.Service;

@Service
public class MedicalExamServiceImpl extends BaseServiceImpl implements MedicalExamService {
    private final MedicalExamRepository medicalExamRepository;

    public MedicalExamServiceImpl(MedicalExamRepository medicalExamRepository) {
        super();
        this.medicalExamRepository = medicalExamRepository;
    }

    @Override
    public MedicalExamDTO create(MedicalExamDTO medicalExamDTO) {
        MedicalExam medicalExam = MedicalExamMapper.toEntity(medicalExamDTO);
        return MedicalExamMapper.toDto(medicalExamRepository.save(medicalExam));
    }

    @Override
    public MedicalExamDTO get(Long id) {
        MedicalExam medicalExam = medicalExamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exame médico não encontrado"));
        return MedicalExamMapper.toDto(medicalExam);
    }

    @Override
    public MedicalExamDTO update(MedicalExamDTO medicalExamDTO) {
        MedicalExam medicalExam = MedicalExamMapper.toEntity(medicalExamDTO);
        return MedicalExamMapper.toDto(medicalExamRepository.save(medicalExam));
    }
}
