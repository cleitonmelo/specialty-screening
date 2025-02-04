package br.com.hackaton.specialtyscreening.service;

import br.com.hackaton.specialtyscreening.controller.resources.ScreeningResource;
import br.com.hackaton.specialtyscreening.dto.ScreeningDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ScreeningService {

    ScreeningDTO create(ScreeningDTO screeningDTO);

    ScreeningDTO get(Long id);

    ScreeningDTO update(ScreeningDTO screeningDto);

    Page<ScreeningResource> findAllBySpecialtyCode(Long specialtyCode, Pageable pageable);
}
