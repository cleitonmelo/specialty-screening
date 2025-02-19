package br.com.hackaton.specialtyscreening.service.impl;

import br.com.hackaton.specialtyscreening.controller.resources.ScreeningResource;
import br.com.hackaton.specialtyscreening.dto.PatientDTO;
import br.com.hackaton.specialtyscreening.dto.ScreeningDTO;
import br.com.hackaton.specialtyscreening.dto.mappers.ScreeningMapper;
import br.com.hackaton.specialtyscreening.enums.ScreeningStatus;
import br.com.hackaton.specialtyscreening.model.Diagnosis;
import br.com.hackaton.specialtyscreening.model.Exam;
import br.com.hackaton.specialtyscreening.model.Screening;
import br.com.hackaton.specialtyscreening.model.SpecialistDoctor;
import br.com.hackaton.specialtyscreening.model.Specialty;
import br.com.hackaton.specialtyscreening.repository.ExamRepository;
import br.com.hackaton.specialtyscreening.repository.ScreeningRepository;
import br.com.hackaton.specialtyscreening.service.PatientService;
import br.com.hackaton.specialtyscreening.service.ScreeningService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScreeningServiceImpl extends BaseServiceImpl implements ScreeningService {

    private final ScreeningRepository screeningRepository;
    private final ExamRepository examRepository;

    private final PatientService patientService;

    public ScreeningServiceImpl(ScreeningRepository screeningRepository, PatientService patientService, ExamRepository examRepository) {
        super();
        this.screeningRepository = screeningRepository;
        this.patientService = patientService;
        this.examRepository = examRepository;
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
        screening.setPatientName(patientDto.getName());

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
