package br.com.hackaton.specialtyscreening.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "service.api.patient")
@Getter @Setter
public class AppServicePatient {
    private String url;
}
