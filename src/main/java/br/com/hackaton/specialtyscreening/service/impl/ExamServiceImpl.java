package br.com.hackaton.specialtyscreening.service.impl;

import br.com.hackaton.specialtyscreening.dto.ExamDTO;
import br.com.hackaton.specialtyscreening.dto.ExamDTORequest;
import br.com.hackaton.specialtyscreening.dto.mappers.ExamMapper;
import br.com.hackaton.specialtyscreening.model.Exam;
import br.com.hackaton.specialtyscreening.repository.ExamRepository;
import br.com.hackaton.specialtyscreening.service.ExamService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamRepository examRepository;

    @Override
    public ExamDTO create(ExamDTORequest examDTORequest) {
        Exam exam = new Exam();
        BeanUtils.copyProperties(examDTORequest, exam);
        return ExamMapper.toDto(examRepository.save(exam));
    }

    @Override
    public Page<ExamDTO> findAll(Pageable pageable) {
        return examRepository.findAll(pageable).map(ExamMapper::toDto);
    }

    @Override
    public Optional<ExamDTO> findById(Long id) {
        return examRepository.findById(id).map(ExamMapper::toDto);
    }

    @Override
    public Optional<ExamDTO> update(Long id, ExamDTORequest examRequest) {
        Optional<Exam> examOptional = examRepository.findById(id);
        if (examOptional.isEmpty()) {
            return examOptional.map(ExamMapper::toDto);
        } else{
            Exam exam = examOptional.get();
            BeanUtils.copyProperties(examRequest, exam, "id");
            Exam savedExam = examRepository.save(exam);
            return Optional.of(savedExam).map(ExamMapper::toDto);
        }
    }

    @Override
    public boolean deleteById(Long id) {
        Optional<Exam> examOptional = examRepository.findById(id);
        if (examOptional.isEmpty()) {
            return false;
        } else {
            examRepository.deleteById(id);
            return true;
        }
    }
}
