package br.com.hackaton.specialtyscreening.service.impl;

import br.com.hackaton.specialtyscreening.controller.resources.ScreeningResource;
import br.com.hackaton.specialtyscreening.dto.PatientDto;
import br.com.hackaton.specialtyscreening.dto.ScreeningDTO;
import br.com.hackaton.specialtyscreening.dto.mappers.ScreeningMapper;
import br.com.hackaton.specialtyscreening.enums.ScreeningStatus;
import br.com.hackaton.specialtyscreening.model.Diagnosis;
import br.com.hackaton.specialtyscreening.model.Screening;
import br.com.hackaton.specialtyscreening.model.SpecialistDoctor;
import br.com.hackaton.specialtyscreening.model.Specialty;
import br.com.hackaton.specialtyscreening.repository.ScreeningRepository;
import br.com.hackaton.specialtyscreening.service.PatientService;
import br.com.hackaton.specialtyscreening.service.ScreeningService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ScreeningServiceImpl extends BaseServiceImpl implements ScreeningService {

    private final ScreeningRepository screeningRepository;

    private final PatientService patientService;

    public ScreeningServiceImpl(ScreeningRepository screeningRepository, PatientService patientService) {
        super();
        this.screeningRepository = screeningRepository;
        this.patientService = patientService;
    }

    @Override
    public ScreeningDTO create(ScreeningDTO screeningDTO)
    {
        Screening screening = ScreeningMapper.toEntity(
                screeningDTO, findSpecialtyById(screeningDTO.specialty()));
        if ( screening.getStatus() == null ) {
            screening.setStatus(ScreeningStatus.AWATING_SPECIALIST);
        }
        PatientDto patientDto = this.patientService.getPatientInfo(screeningDTO.patientCode());
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
    public ScreeningResource finishedDiagnosis(Long id, Diagnosis diagnosis) {
        Screening screening = screeningRepository.findById(id).orElse(null);
        if ( screening != null ) {
            screening.setStatus(ScreeningStatus.COMPLETED_DIAGNOSIS);
            //screening.setDiagnosis(diagnosis);
            ScreeningDTO screeningDTO = ScreeningMapper.toDto(screening);
            return ScreeningMapper.toResourceByModel(
                    screeningRepository.save(ScreeningMapper.toEntityByDoctor(screeningDTO,
                            findSpecialtyById(screening.getSpecialty().getId()),
                            findDoctorById(screening.getSpecialty().getId()))
                    ));
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
