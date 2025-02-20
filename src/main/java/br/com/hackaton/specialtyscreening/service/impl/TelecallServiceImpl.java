package br.com.hackaton.specialtyscreening.service.impl;

import br.com.hackaton.specialtyscreening.dto.TelecallDTO;
import br.com.hackaton.specialtyscreening.dto.mappers.TeleCallMapper;
import br.com.hackaton.specialtyscreening.model.Telecall;
import br.com.hackaton.specialtyscreening.repository.TelecallRepository;
import br.com.hackaton.specialtyscreening.service.TelecallService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TelecallServiceImpl extends BaseServiceImpl implements TelecallService {

    private final TelecallRepository telecallRepository;

    public TelecallServiceImpl(TelecallRepository telecallRepository) {
        this.telecallRepository = telecallRepository;
    }
    @Override
    public TelecallDTO save(TelecallDTO telecallDTO) {
        Telecall telecall = telecallRepository.save(TeleCallMapper.toEntity(telecallDTO));
        return TeleCallMapper.toDTO(telecall);
    }

    @Override
    public TelecallDTO update(Long id,TelecallDTO telecallDTO) {
        Telecall telecall = telecallRepository.findById(id).orElse(null);
        if (telecall != null) {
            return this.update(id, telecallDTO);
        }
        return null;
    }

    @Override
    public TelecallDTO findById(Long id) {
        Telecall telecall = telecallRepository.findById(id).orElse(null);
        if (telecall != null) {
            return TeleCallMapper.toDTO(telecall);
        }
        return null;

    }

    @Override
    public List<TelecallDTO> findAll() {

        List<Telecall> telecalls = telecallRepository.findAll();
        List<TelecallDTO> telecallDTOS = new ArrayList<>();
        for (Telecall telecall : telecalls) {
            telecallDTOS.add(TeleCallMapper.toDTO(telecall));
        }
        if (telecallDTOS.size() > 0) {
            return telecallDTOS;
        }
        return null;
    }

    @Override
    public Page<TelecallDTO> findAll(Pageable pageable){
        Page<Telecall> telecalls = telecallRepository.findAll(pageable);
        return telecalls.map(TeleCallMapper::toDTO);
    }

    @Override
    public Boolean deleteById(Long id) {
        Telecall telecall = telecallRepository.findById(id).orElse(null);
        if (telecall != null) {
            telecallRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
