package br.com.hackaton.specialtyscreening.controller;

import br.com.hackaton.specialtyscreening.service.impl.SpecialtyServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Pageable;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class SpecialtyControllerTest {

    @Mock
    SpecialtyServiceImpl service;

    SpecialtyController controller;

    AutoCloseable openMocks;

    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
        controller = new SpecialtyController(service);
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void mustReturnSpecialtyList(){
        var presenter = controller.findAll(Pageable.unpaged());
        assertThat(presenter.getBody()).isNull();
    }
}
