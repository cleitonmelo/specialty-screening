package br.com.hackaton.specialtyscreening.controller;

import br.com.hackaton.specialtyscreening.controller.resources.BaseResource;
import br.com.hackaton.specialtyscreening.controller.resources.ExceptionResource;
import org.springframework.http.ResponseEntity;

public abstract class BaseController {

    public ResponseEntity<BaseResource> badRequestException(String httpStatusName,
                                                            String message) {
        return ResponseEntity.badRequest().body(ExceptionResource.builder()
                .error(httpStatusName)
                .message(message)
                .build());
    }
}
