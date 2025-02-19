package br.com.hackaton.specialtyscreening.job;

import br.com.hackaton.specialtyscreening.controller.resources.ScreeningResource;
import br.com.hackaton.specialtyscreening.dto.mappers.ScreeningMapper;
import br.com.hackaton.specialtyscreening.enums.ScreeningStatus;
import br.com.hackaton.specialtyscreening.model.Screening;
import br.com.hackaton.specialtyscreening.service.ScreeningService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class UpdateMedicalExamResultJob implements BaseJob{

    private final ScreeningService screeningService;

    public UpdateMedicalExamResultJob(ScreeningService screeningService) {
        this.screeningService = screeningService;
    }

    @Value("${job.exam.update.interval}")

    @Scheduled(fixedRateString = "${job.exam.update.interval}")
    public void updateResultExams() {

        log.info("Updating Medical Exam Results");
        try {
            List<Screening> screenings = screeningService.findAllByStatus(ScreeningStatus.AWAITING_EXAMS);
            if (screenings.isEmpty()) {
                log.info("No Medical Exam Results found");
            }
            for (Screening screening : screenings) {
                log.info("This Medical exam will be updated: "+screening.getId());
                screeningService.updateCompletedExamStatus(screening.getId());
            }

        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }



//        screeningService
//                .findAllByStatus(ScreeningStatus.AWAITING_EXAMS.getCode()).forEach(screening -> {
//                    log.info("This Medical exam will be updated: "+screening.toString());
//                    screeningService.update(ScreeningMapper.resourceToDto(screening));
//                });
    }
}
