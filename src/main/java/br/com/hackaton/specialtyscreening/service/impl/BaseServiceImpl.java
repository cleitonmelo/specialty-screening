package br.com.hackaton.specialtyscreening.service.impl;

import br.com.hackaton.specialtyscreening.service.BaseService;

public abstract class BaseServiceImpl implements BaseService {

    @Override
    public boolean isSpecialtyExists(int specialtyId) {
        return false;
    }
}
