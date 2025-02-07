package br.com.hackaton.specialtyscreening.service.impl;

import br.com.hackaton.specialtyscreening.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class BaseServiceImpl implements BaseService {

    @Override
    public boolean isSpecialtyExists(Long specialtyId) {
        return false;
    }

    @Override
    public boolean isSpecialistExists(Long specialistId) {
        return false;
    }
}