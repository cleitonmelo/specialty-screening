package br.com.hackaton.specialtyscreening.service;

import br.com.hackaton.specialtyscreening.dto.ExamDTORequest;
import br.com.hackaton.specialtyscreening.model.Exam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ExamService {
    Exam create(ExamDTORequest exam);
    Page<Exam> findAll(Pageable pageable);
    Optional<Exam> findById(Long id);
    Optional<Exam> update(Long id, ExamDTORequest exam);
    boolean deleteById(Long id);

}
