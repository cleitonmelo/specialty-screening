package br.com.hackaton.specialtyscreening.service.impl;

import br.com.hackaton.specialtyscreening.util.SendEmail;
import br.com.hackaton.specialtyscreening.service.ScreeningService;
import org.springframework.stereotype.Service;

@Service
public class ScreeningServiceImpl implements ScreeningService {

    private final SendEmail mailService;

    public ScreeningServiceImpl(SendEmail mailService) {
        this.mailService = mailService;
    }

    @Override
    public String create()
    {
        this.mailService.sendEmail("teste@email.com",
                "Notificação de Nova Triagem - Especialista",
                "<h1> Hackaton - Fiap 2025 </h1>");
        return "Formulário de triagem criado com sucesso!";
    }

    @Override
    public String update()
    {
        this.mailService.sendEmail("teste@email.com",
                "Notificação de Atualização Triagem - Paciente",
                "<h1> Hackaton - Fiap 2025 </h1>");
        return "Formulário atualizado com sucesso";
    }

    @Override
    public String get(String id) {
        return "Detalhes do Id: " + id;
    }
}
