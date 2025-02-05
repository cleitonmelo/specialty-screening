package br.com.hackaton.specialtyscreening.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.hackaton.specialtyscreening.service.ExamService;

@Component
public class UpdateExamResultJob {
    @Autowired
    private ExamService examService;

    @Scheduled(fixedRate = 5000) // Executa a cada 5 segundos
    public void updateResultExams() {
        System.out.println("Atualizando resultados de exames...");
        examService.updateResultExams();
    }
}
