package br.com.hackaton.specialtyscreening.service;

import br.com.hackaton.specialtyscreening.dto.SpecialistDoctorDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SpecialistDoctorService {

    SpecialistDoctorDTO save(SpecialistDoctorDTO dto);

    SpecialistDoctorDTO get(Long id);

    SpecialistDoctorDTO update(Long id, SpecialistDoctorDTO dto);

    Page<SpecialistDoctorDTO> findAll(Pageable pageable);
}
