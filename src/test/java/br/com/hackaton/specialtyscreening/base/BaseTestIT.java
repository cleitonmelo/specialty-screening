package br.com.hackaton.specialtyscreening.base;

import br.com.hackaton.specialtyscreening.dto.ScreeningDTO;

public abstract class BaseTestIT {

    public String URI;

    public static final String BASE_API = "/api/v1";

    public String getBaseUri()
    {
        return BASE_API + "/" + URI;
    }

    public static ScreeningDTO getScreeningDTOForTest(){
        return ScreeningDTO.builder()
                .patientCode("123456789")
                .specialty(1L)
                .build();
    }
}
