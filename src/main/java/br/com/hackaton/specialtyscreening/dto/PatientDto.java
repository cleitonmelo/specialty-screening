package br.com.hackaton.specialtyscreening.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class PatientDto {
    private String id;
    private String name;
    private String cpf;
    private String rne;
    private String birthDate;
    private String email;
    private String phone;
    private List<PatientAddressesDto> addresses;
}
