package br.com.hackaton.specialtyscreening.base;

import br.com.hackaton.specialtyscreening.dto.ScreeningDTO;

public abstract class BaseTestIT {

    private String uri;

    public static final String BASE_API = "/api/v1";

    public void setURI(String value){
        this.uri = value;
    }

    public String getBaseUri()
    {
        return BASE_API + "/" + this.uri;
    }

    public static ScreeningDTO getScreeningDTOForTest(){
        return ScreeningDTO.builder()
                .patientCode("123456789")
                .specialty(1L)
                .build();
    }
}
