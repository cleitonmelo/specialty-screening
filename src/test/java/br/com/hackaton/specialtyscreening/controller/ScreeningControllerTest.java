package br.com.hackaton.specialtyscreening.controller;

import br.com.hackaton.specialtyscreening.service.impl.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Pageable;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ScreeningControllerTest {

    @Mock
    ScreeningServiceImpl screeningService;

    @Mock
    SpecialtyServiceImpl specialtyService;

    @Mock
    SpecialistDoctorServiceImpl specialistDoctorService;

    @Mock
    DiagnosisServiceImpl diagnosisService;

    @Mock
    ExamServiceImpl examService;

    ScreeningController controller;

    AutoCloseable openMocks;

    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
        controller = new ScreeningController(this.screeningService
                ,this.specialtyService, this.specialistDoctorService, this.diagnosisService, this.examService);
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void mustReturnScreeningList(){
        var presenter = controller.findScreeningBySpecialtyCode(null,
                Pageable.unpaged());
        assertThat(presenter.getBody()).isNull();
    }
}
