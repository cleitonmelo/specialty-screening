package br.com.hackaton.specialtyscreening.service.impl;

import br.com.hackaton.specialtyscreening.config.AppServiceTelecall;
import br.com.hackaton.specialtyscreening.dto.TelecallDTO;
import br.com.hackaton.specialtyscreening.dto.mappers.TeleCallMapper;
import br.com.hackaton.specialtyscreening.model.Telecall;
import br.com.hackaton.specialtyscreening.repository.TelecallRepository;
import br.com.hackaton.specialtyscreening.service.TelecallService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class TelecallServiceImpl extends BaseServiceImpl implements TelecallService {

    private final TelecallRepository telecallRepository;

    private final AppServiceTelecall appServiceTelecall;

    public TelecallServiceImpl(TelecallRepository telecallRepository, AppServiceTelecall appServiceTelecall) {
        this.telecallRepository = telecallRepository;
        this.appServiceTelecall = appServiceTelecall;
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
    @Override
    public TelecallDTO getTelecallInfo(Long id){
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<TelecallDTO> response = restTemplate
                .getForEntity(appServiceTelecall.getUrl() + id,
                        TelecallDTO.class);
        if(response.getStatusCode().is2xxSuccessful()){
            return response.getBody();
        }
        return null;
    }
}
