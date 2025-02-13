package br.com.hackaton.specialtyscreening.dto;

import lombok.Builder;

@Builder
public class PatientAddressesDto {
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String zipCode;
}
