package br.com.hackaton.specialtyscreening.service;

import br.com.hackaton.specialtyscreening.dto.ScreeningDTO;

public interface ScreeningService {

    ScreeningDTO create(ScreeningDTO screeningDTO);

    ScreeningDTO get(Long id);

    ScreeningDTO update(ScreeningDTO screeningDto);
}
