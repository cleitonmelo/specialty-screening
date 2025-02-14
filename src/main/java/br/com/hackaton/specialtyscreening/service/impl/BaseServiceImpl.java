package br.com.hackaton.specialtyscreening.service.impl;

import br.com.hackaton.specialtyscreening.model.SpecialistDoctor;
import br.com.hackaton.specialtyscreening.model.Specialty;
import br.com.hackaton.specialtyscreening.repository.SpecialistDoctorRepository;
import br.com.hackaton.specialtyscreening.repository.SpecialtyRepository;
import br.com.hackaton.specialtyscreening.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseServiceImpl implements BaseService {

    @Autowired
    private SpecialtyRepository specialtyRepository;

    @Autowired
    private SpecialistDoctorRepository specialistDoctorRepository;

    @Override
    public boolean isSpecialtyExists(Long specialtyId) {
        Specialty specialty = specialtyRepository.findById(specialtyId).orElse(null);
        return specialty != null;
    }

    @Override
    public boolean isSpecialistExists(Long specialistId) {
        SpecialistDoctor specialistDoctor = specialistDoctorRepository.findById(specialistId).orElse(null);
        return specialistDoctor != null;
    }
}