package br.com.hackaton.specialtyscreening.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "service.api.telecall")
@Getter @Setter
public class AppServiceTeleCall {
    private String url;
}