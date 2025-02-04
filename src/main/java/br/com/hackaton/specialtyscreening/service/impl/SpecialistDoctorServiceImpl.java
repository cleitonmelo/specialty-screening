package br.com.hackaton.specialtyscreening.service.impl;

import br.com.hackaton.specialtyscreening.dto.SpecialistDoctorDTO;
import br.com.hackaton.specialtyscreening.dto.mappers.SpecialistDoctorMapper;
import br.com.hackaton.specialtyscreening.model.SpecialistDoctor;
import br.com.hackaton.specialtyscreening.repository.SpecialistDoctorRepository;
import br.com.hackaton.specialtyscreening.service.SpecialistDoctorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SpecialistDoctorServiceImpl implements SpecialistDoctorService {

    private final SpecialistDoctorRepository repository;

    public SpecialistDoctorServiceImpl(SpecialistDoctorRepository repository) {
        this.repository = repository;
    }

    @Override
    public SpecialistDoctorDTO save(SpecialistDoctorDTO dto) {
        SpecialistDoctor specialistDoctor = this.repository.save(
                SpecialistDoctorMapper.toEntity(dto));
        return SpecialistDoctorMapper.toDto(specialistDoctor);
    }

    @Override
    public SpecialistDoctorDTO get(Long id) {
        SpecialistDoctor specialistDoctor = this.repository.findById(id).orElse(null);
        if (specialistDoctor == null) {
            return null;
        }
        return SpecialistDoctorMapper.toDto(specialistDoctor);
    }

    @Override
    public SpecialistDoctorDTO update(Long id, SpecialistDoctorDTO dto) {
        SpecialistDoctor specialty = this.repository.findById(id).orElse(null);
        if (specialty != null) {
            SpecialistDoctorDTO doctor = SpecialistDoctorDTO.builder()
                    .id(id).name(dto.name()).specialties(dto.specialties()).build();
            return this.save(doctor);
        }
        return null;
    }

    @Override
    public Page<SpecialistDoctorDTO> findAll(Pageable pageable) {
        Page<SpecialistDoctor> doctors = this.repository.findAll(pageable);
        return doctors.map(SpecialistDoctorMapper::toDto);
    }
}
