package br.com.hackaton.specialtyscreening.service;

import br.com.hackaton.specialtyscreening.dto.ExamDTO;
import br.com.hackaton.specialtyscreening.dto.ExamDTORequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ExamService {
    ExamDTO create(ExamDTORequest exam);
    Page<ExamDTO> findAll(Pageable pageable);
    Optional<ExamDTO> findById(Long id);
    Optional<ExamDTO> update(Long id, ExamDTORequest exam);
    boolean deleteById(Long id);

}
