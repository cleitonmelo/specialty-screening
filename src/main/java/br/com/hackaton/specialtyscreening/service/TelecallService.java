package br.com.hackaton.specialtyscreening.service;

import br.com.hackaton.specialtyscreening.dto.TelecallDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TelecallService extends BaseService{
    TelecallDTO save(TelecallDTO telecallDTO);
    TelecallDTO update(Long id,TelecallDTO telecallDTO);
    TelecallDTO findById(Long id);
    List<TelecallDTO> findAll();
    Page<TelecallDTO> findAll(Pageable pageable);
    Boolean deleteById(Long id);

}
