package br.com.hackaton.specialtyscreening.service.impl;

import br.com.hackaton.specialtyscreening.controller.resources.ScreeningResource;
import br.com.hackaton.specialtyscreening.controller.resources.TeleCallResource;
import br.com.hackaton.specialtyscreening.dto.PatientDTO;
import br.com.hackaton.specialtyscreening.dto.ScreeningDTO;
import br.com.hackaton.specialtyscreening.dto.TeleCallDTO;
import br.com.hackaton.specialtyscreening.dto.mappers.ScreeningMapper;
import br.com.hackaton.specialtyscreening.dto.mappers.TeleCallMapper;
import br.com.hackaton.specialtyscreening.enums.ScreeningStatus;
import br.com.hackaton.specialtyscreening.model.*;
import br.com.hackaton.specialtyscreening.repository.ExamRepository;
import br.com.hackaton.specialtyscreening.repository.ScreeningRepository;
import br.com.hackaton.specialtyscreening.service.PatientService;
import br.com.hackaton.specialtyscreening.service.ScreeningService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ScreeningServiceImpl extends BaseServiceImpl implements ScreeningService {

    private final ScreeningRepository screeningRepository;
    private final ExamRepository examRepository;
    private final PatientService patientService;
    private final TeleCallServiceImpl teleCallService;

    public ScreeningServiceImpl(ScreeningRepository screeningRepository, PatientService patientService, ExamRepository examRepository, TeleCallServiceImpl teleCallService) {
        super();
        this.screeningRepository = screeningRepository;
        this.patientService = patientService;
        this.examRepository = examRepository;
        this.teleCallService = teleCallService;
    }

    @Override
    public ScreeningDTO create(ScreeningDTO screeningDTO)
    {
        Screening screening = ScreeningMapper.toEntity(
                screeningDTO, findSpecialtyById(screeningDTO.specialty()));
        if ( screening.getStatus() == null ) {
            screening.setStatus(ScreeningStatus.AWATING_SPECIALIST);
        }
        PatientDTO patientDto = this.patientService.getPatientInfo(screeningDTO.patientCode());
        if ( patientDto != null ) {
            screening.setPatientName(patientDto.getName());
        }
        return ScreeningMapper.toDto(screeningRepository.save(screening));
    }

    @Override
    public ScreeningDTO update(ScreeningDTO screeningDTO)
    {
        Screening screening = ScreeningMapper.toEntity(
                screeningDTO, findSpecialtyById(screeningDTO.specialty()));
        return ScreeningMapper.toDto(screeningRepository.save(screening));
    }

    @Override
    public Page<ScreeningResource> findAllBySpecialtyCode(Long specialtyId, Pageable pageable) {
        Page<Screening> screenings = screeningRepository.findBySpecialtyId(specialtyId, pageable);
        return screenings.map(ScreeningMapper::toResourceByModel);
    }

    @Override
    public ScreeningResource associateSpecialist(Long specialistId, Long id) {
        Screening screening = screeningRepository.findById(id).orElse(null);
        if ( screening != null ) {
            screening.setStatus(ScreeningStatus.IN_ANALYSIS);
            ScreeningDTO screeningDTO = ScreeningMapper.toDto(screening);
            return ScreeningMapper.toResourceByModel(
                        screeningRepository.save(ScreeningMapper.toEntityByDoctor(screeningDTO,
                                findSpecialtyById(screening.getSpecialty().getId()),
                                findDoctorById(specialistId))
                        ));
        }
        return null;
    }

    @Override
    public ScreeningResource associateExam(Long examId, Long id) {
        Screening screening = screeningRepository.findById(id).orElse(null);
        Exam exam = examRepository.findById(examId).orElse(null);
        if ( screening != null && exam != null) {

            if (screening.getExam() == null) {
                screening.setExam(new ArrayList<Exam>());
            }

            screening.getExam().add(exam);
            screening.setStatus(ScreeningStatus.AWAITING_EXAMS);
            Screening save = screeningRepository.save(screening);
            return ScreeningMapper.toResourceByModel(save);
        }
        return null;
    }

    @Override
    public ScreeningResource finishedDiagnosis(Long id, Diagnosis diagnosis) {
        Screening screening = screeningRepository.findById(id).orElse(null);
        if ( screening != null ) {
            screening.setStatus(ScreeningStatus.COMPLETED_DIAGNOSIS);
            screening.setDiagnosis(diagnosis);
            ScreeningDTO screeningDTO = ScreeningMapper.toDto(screening);
            return ScreeningMapper.toResourceByModel(
                    screeningRepository.save(ScreeningMapper.toEntityByDoctor(screeningDTO,
                            findSpecialtyById(screening.getSpecialty().getId()),
                            findDoctorById(screening.getSpecialistDoctor().getId()))
                    ));
        }
        return null;
    }

    @Override
    public Page<ScreeningResource> findAll(Pageable pageable) {
        Page<Screening> screenings = screeningRepository.findAll(pageable);
        return screenings.map(ScreeningMapper::toResourceByModel);
    }

    @Override
    public List<Screening> findAllByStatus(ScreeningStatus status) {
        return screeningRepository.findAllByStatus(status);
    }

    @Override
    public void updateCompletedExamStatus(Long id) {
        Screening screening = screeningRepository.findById(id).orElse(null);
        if ( screening != null ) {
            screening.setStatus(ScreeningStatus.COMPLETED_EXAMS);
            screeningRepository.save(screening);
        }
    }

    @Override
    public ScreeningResource setIdTeleCall(Long id) {
        Screening screening = screeningRepository.findById(id).orElse(null);
        if ( screening != null ) {
            TeleCallDTO teleCallDTO = teleCallService.setIdTeleCall();
            screening.setTeleCall(TeleCallMapper.toEntity(teleCallDTO));
            screening.setStatus(ScreeningStatus.AWAITING_TELECALL);
            Screening save = screeningRepository.save(screening);
            return ScreeningMapper.toResourceByModel(save);
        }
        return null;
    }

    @Override
    public ScreeningResource startTeleCall(Long id) {
        Screening screening = screeningRepository.findById(id).orElse(null);
        if ( screening != null ) {
            TeleCallDTO teleCallDTO = teleCallService.start(screening.getTeleCall());
            screening.setTeleCall(TeleCallMapper.toEntity(teleCallDTO));
            screening.setStatus(ScreeningStatus.STARTED_TELECALL);
            Screening save = screeningRepository.save(screening);
            return ScreeningMapper.toResourceByModel(save);
        }
        return null;
    }

    @Override
    public ScreeningResource endTeleCall(Long id) {
        Screening screening = screeningRepository.findById(id).orElse(null);
        if ( screening != null ) {
            TeleCallDTO teleCallDTO = teleCallService.stop(screening.getTeleCall());
            screening.setTeleCall(TeleCallMapper.toEntity(teleCallDTO));
            screening.setStatus(ScreeningStatus.FINISHED_TELECALL);
            Screening save = screeningRepository.save(screening);
            return ScreeningMapper.toResourceByModel(save);
        }
        return null;
    }

    @Override
    public ScreeningDTO get(Long id) {
        Screening screening = screeningRepository.findById(id).orElse(null);
        if ( screening == null) {
            return null;
        }
        return ScreeningMapper.toDto(screening);
    }

    private Specialty findSpecialtyById(Long id) {
        return Specialty.builder().id(id).build();
    }

    private SpecialistDoctor findDoctorById(Long id) {
        return SpecialistDoctor.builder().id(id).build();
    }

}
