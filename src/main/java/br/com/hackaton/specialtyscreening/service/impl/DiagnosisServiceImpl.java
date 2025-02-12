package br.com.hackaton.specialtyscreening.service.impl;

import br.com.hackaton.specialtyscreening.dto.DiagnosisDTO;
import br.com.hackaton.specialtyscreening.dto.mappers.DiagnosisMapper;
import br.com.hackaton.specialtyscreening.model.Diagnosis;
import br.com.hackaton.specialtyscreening.repository.DiagnosisRepository;
import br.com.hackaton.specialtyscreening.service.DiagnosisService;
import org.springframework.stereotype.Service;

@Service
public class DiagnosisServiceImpl extends BaseServiceImpl implements DiagnosisService {

    private final DiagnosisRepository repository;

    public DiagnosisServiceImpl(DiagnosisRepository repository) {
        super();
        this.repository = repository;
    }

    @Override
    public Diagnosis create(DiagnosisDTO diagnosisDTO)
    {
        Diagnosis diagnosis = DiagnosisMapper.toEntity(diagnosisDTO);
        return repository.save(diagnosis);
    }


}
