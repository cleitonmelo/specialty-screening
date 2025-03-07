package br.com.hackaton.specialtyscreening.service;

import br.com.hackaton.specialtyscreening.dto.SpecialtyDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SpecialtyService {

    SpecialtyDTO save(SpecialtyDTO dto);

    SpecialtyDTO get(Long id);

    SpecialtyDTO update(Long id, SpecialtyDTO dto);

    Page<SpecialtyDTO> findAll(Pageable pageable);
}
