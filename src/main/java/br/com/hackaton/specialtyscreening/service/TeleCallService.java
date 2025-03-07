package br.com.hackaton.specialtyscreening.service;

import br.com.hackaton.specialtyscreening.dto.TeleCallDTO;
import br.com.hackaton.specialtyscreening.model.TeleCall;

public interface TeleCallService {

    TeleCallDTO setIdTeleCall();
    TeleCallDTO start(TeleCall teleCall);
    TeleCallDTO stop(TeleCall teleCall);
}
