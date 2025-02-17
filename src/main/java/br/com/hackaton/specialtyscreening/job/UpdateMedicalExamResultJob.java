package br.com.hackaton.specialtyscreening.job;

import br.com.hackaton.specialtyscreening.dto.MedicalExamDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import br.com.hackaton.specialtyscreening.service.MedicalExamService;

@Slf4j
@Component
public class UpdateMedicalExamResultJob implements BaseJob{

    @Autowired
    private MedicalExamService medicalExamService;

    @Scheduled(fixedRate = 15000) // Executa a cada 5 segundos
    public void updateResultExams() {

        log.info("Updating Medical Exam Results");
        MedicalExamDTO medicalExamDTO = new MedicalExamDTO(1L,"new","Exemplo resultado");
        medicalExamService.update(medicalExamDTO);
    }
}
