package br.com.hackaton.specialtyscreening.service.impl;

import br.com.hackaton.specialtyscreening.dto.SpecialtyDTO;
import br.com.hackaton.specialtyscreening.dto.mappers.SpecialtyMapper;
import br.com.hackaton.specialtyscreening.model.Specialty;
import br.com.hackaton.specialtyscreening.repository.SpecialtyRepository;
import br.com.hackaton.specialtyscreening.service.SpecialtyService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SpecialtyServiceImpl implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialtyServiceImpl(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public SpecialtyDTO create(SpecialtyDTO dto) {
        Specialty specialty = specialtyRepository.save(SpecialtyMapper.toEntity(dto));
        return SpecialtyMapper.toDto(specialty);
    }

    @Override
    public SpecialtyDTO get(Long id) {
        Specialty specialty = specialtyRepository.findById(id).orElse(null);
        if ( specialty != null) {
            return SpecialtyMapper.toDto(specialty);
        }
        return null;
    }

    @Override
    public SpecialtyDTO update(Long id, SpecialtyDTO dto) {
        Specialty specialty = specialtyRepository.findById(id).orElse(null);
        if (specialty != null) {
            SpecialtyDTO specialtyDTO = SpecialtyDTO.builder().id(id).name(dto.name()).build();
            return SpecialtyMapper.toDto(specialtyRepository.save(SpecialtyMapper.toEntity(specialtyDTO)));
        }
        return null;
    }

    @Override
    public Page<SpecialtyDTO> findAll(Pageable pageable) {
        Page<Specialty> specialties = specialtyRepository.findAll(pageable);
        return specialties.map(SpecialtyMapper::toDto);
    }
}
