package br.com.hackaton.specialtyscreening.service;

import br.com.hackaton.specialtyscreening.dto.SpecialistDoctorDTO;
import br.com.hackaton.specialtyscreening.dto.SpecialtyDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SpecialistDoctorService extends BaseService{

    SpecialistDoctorDTO save(SpecialistDoctorDTO dto);

    SpecialistDoctorDTO get(Long id);

    SpecialistDoctorDTO update(Long id, SpecialistDoctorDTO dto);

    Page<SpecialistDoctorDTO> findAll(Pageable pageable);

    List<SpecialtyDTO> specialities(SpecialtyDTO t);

}
