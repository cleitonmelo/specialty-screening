package br.com.hackaton.specialtyscreening.service;

import br.com.hackaton.specialtyscreening.controller.resources.ScreeningResource;
import br.com.hackaton.specialtyscreening.dto.ScreeningDTO;
import br.com.hackaton.specialtyscreening.enums.ScreeningStatus;
import br.com.hackaton.specialtyscreening.model.Diagnosis;
import br.com.hackaton.specialtyscreening.model.Screening;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ScreeningService extends BaseService{

    ScreeningDTO create(ScreeningDTO screeningDTO);

    ScreeningDTO get(Long id);

    ScreeningDTO update(ScreeningDTO screeningDto);

    Page<ScreeningResource> findAllBySpecialtyCode(Long specialtyCode, Pageable pageable);

    ScreeningResource associateSpecialist(Long specialistId, Long id);

    ScreeningResource associateExam(Long examId, Long id);

    ScreeningResource finishedDiagnosis(Long id, Diagnosis diagnosis);

    Page<ScreeningResource> findAll(Pageable pageable);

    List<Screening> findAllByStatus(ScreeningStatus status);

    void updateCompletedExamStatus(Long id);

    void setIdTeleCall();

    void startTelecall();

    void endTelecall();
}
