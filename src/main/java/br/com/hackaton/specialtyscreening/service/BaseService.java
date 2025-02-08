package br.com.hackaton.specialtyscreening.service;

public abstract interface BaseService {

    boolean isSpecialtyExists(Long specialtyId);

    boolean isSpecialistExists(Long specialistId);
}
