package br.com.hackaton.specialtyscreening.service.impl;

import br.com.hackaton.specialtyscreening.config.AppServiceTeleCall;
import br.com.hackaton.specialtyscreening.dto.TeleCallDTO;
import br.com.hackaton.specialtyscreening.model.TeleCall;
import br.com.hackaton.specialtyscreening.service.TeleCallService;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class TeleCallServiceImpl implements TeleCallService {

    public final AppServiceTeleCall appServiceTeleCall;

    public TeleCallServiceImpl(AppServiceTeleCall appServiceTeleCall) {
        this.appServiceTeleCall = appServiceTeleCall;
    }
    @Override
    public TeleCallDTO setIdTeleCall() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<TeleCallDTO> response = restTemplate.postForEntity(
                appServiceTeleCall.getUrl(),null,
                TeleCallDTO.class);

        if ( response.getStatusCode().is2xxSuccessful() ) {
            return response.getBody();
        }

        return null;
    }
    @Override
    public TeleCallDTO start(TeleCall teleCall) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UUID> requestEntity = new HttpEntity<>(teleCall.getId(), headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<TeleCallDTO> response = restTemplate.exchange(
                appServiceTeleCall.getUrl()+"/"+teleCall.getId().toString(),
                HttpMethod.PUT,
                requestEntity,
                TeleCallDTO.class);

        if ( response.getStatusCode().is2xxSuccessful() ) {
            return response.getBody();
        }

        return null;
    }

    @Override
    public TeleCallDTO stop(TeleCall teleCall) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UUID> requestEntity = new HttpEntity<>(teleCall.getId(), headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<TeleCallDTO> response = restTemplate.exchange(
                appServiceTeleCall.getUrl()+"/"+teleCall.getId().toString(),
                HttpMethod.PUT,
                requestEntity,
                TeleCallDTO.class);

        if ( response.getStatusCode().is2xxSuccessful() ) {
            return response.getBody();
        }

        return null;
    }
}
