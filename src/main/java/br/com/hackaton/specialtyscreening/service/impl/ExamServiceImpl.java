package br.com.hackaton.specialtyscreening.service.impl;

import br.com.hackaton.specialtyscreening.dto.ExamDTORequest;
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
    public Exam create(ExamDTORequest examDTORequest) {
        Exam exam = new Exam();
        BeanUtils.copyProperties(examDTORequest, exam);
        return examRepository.save(exam);
    }

    @Override
    public Page<Exam> findAll(Pageable pageable) {
        return examRepository.findAll(pageable);
    }

    @Override
    public Optional<Exam> findById(Long id) {
        return examRepository.findById(id);
    }

    @Override
    public Optional<Exam> update(Long id, ExamDTORequest examRequest) {
        Optional<Exam> examOptional = examRepository.findById(id);
        if (examOptional.isEmpty()) {
            return examOptional;
        } else{
            Exam exam = examOptional.get();
            BeanUtils.copyProperties(examRequest, exam, "id");
            Exam savedExam = examRepository.save(exam);
            return Optional.of(savedExam);
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
