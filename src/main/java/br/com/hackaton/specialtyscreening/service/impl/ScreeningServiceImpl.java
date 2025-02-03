package br.com.hackaton.specialtyscreening.service.impl;

import br.com.hackaton.specialtyscreening.dto.ScreeningDTO;
import br.com.hackaton.specialtyscreening.dto.mappers.ScreeningMapper;
import br.com.hackaton.specialtyscreening.enums.ScreeningStatus;
import br.com.hackaton.specialtyscreening.model.Screening;
import br.com.hackaton.specialtyscreening.repository.ScreeningRepository;
import br.com.hackaton.specialtyscreening.util.SendEmail;
import br.com.hackaton.specialtyscreening.service.ScreeningService;
import org.springframework.stereotype.Service;

@Service
public class ScreeningServiceImpl implements ScreeningService {

    private final ScreeningRepository screeningRepository;

    public ScreeningServiceImpl(ScreeningRepository screeningRepository) {
        this.screeningRepository = screeningRepository;
    }

    @Override
    public ScreeningDTO create(ScreeningDTO screeningDTO)
    {
        Screening screening = ScreeningMapper.toEntity(screeningDTO);
        if ( screening.getStatus() == null ) {
            screening.setStatus(ScreeningStatus.AWATING_SPECIALIST);
        }
        return ScreeningMapper.toDto(screeningRepository.save(screening));
    }

    @Override
    public ScreeningDTO update(ScreeningDTO screeningDTO)
    {
        Screening screening = ScreeningMapper.toEntity(screeningDTO);
        return ScreeningMapper.toDto(screeningRepository.save(screening));
    }

    @Override
    public ScreeningDTO get(Long id) {
        Screening screening = screeningRepository.findById(id).orElse(null);
        if ( screening == null) {
            return null;
        }
        return ScreeningMapper.toDto(screening);
    }
}
