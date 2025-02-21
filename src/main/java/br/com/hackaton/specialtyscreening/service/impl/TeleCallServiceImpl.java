package br.com.hackaton.specialtyscreening.service.impl;

import br.com.hackaton.specialtyscreening.config.AppServiceTeleCall;
import br.com.hackaton.specialtyscreening.dto.TeleCallDTO;
import br.com.hackaton.specialtyscreening.model.TeleCall;
import br.com.hackaton.specialtyscreening.service.TeleCallService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class TeleCallServiceImpl implements TeleCallService {

    public final AppServiceTeleCall appServiceTeleCall;

    public TeleCallServiceImpl() {
        this.appServiceTeleCall = new AppServiceTeleCall();
    }
    @Override
    public TeleCallDTO schedule() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<TeleCallDTO> response = restTemplate.getForEntity(
                appServiceTeleCall.getUrl(),
                TeleCallDTO.class);

        if ( response.getStatusCode().is2xxSuccessful() ) {
            return response.getBody();
        }

        return null;
    }

    @Override
    public TeleCallDTO start(TeleCall teleCall) {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<TeleCallDTO> response = restTemplate.getForEntity(
                appServiceTeleCall.getUrl() +"/{id}",
                TeleCallDTO.class,teleCall.getId());

        if ( response.getStatusCode().is2xxSuccessful() ) {
            return response.getBody();
        }

        return null;
    }

    @Override
    public TeleCallDTO stop(TeleCall teleCall) {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<TeleCallDTO> response = restTemplate.getForEntity(
                appServiceTeleCall.getUrl() +"/{id}",
                TeleCallDTO.class,teleCall.getId());

        if ( response.getStatusCode().is2xxSuccessful() ) {
            return response.getBody();
        }

        return null;
    }
}
