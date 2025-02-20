package br.com.hackaton.specialtyscreening.controller;

import br.com.hackaton.specialtyscreening.dto.ExamDTO;
import br.com.hackaton.specialtyscreening.dto.ExamDTORequest;
import br.com.hackaton.specialtyscreening.service.ExamService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ExamControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ExamService examService;

    @Autowired
    private ObjectMapper objectMapper;

    AutoCloseable openMocks;

    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
        ExamController examController = new ExamController(examService);
        mockMvc = MockMvcBuilders.standaloneSetup(examController)
                .addFilter((request, response, chain) -> {
                    response.setCharacterEncoding("UTF-8");
                    chain.doFilter(request, response);
                }, "/*")
                .build();
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void devePermitirCriarUmExame() throws Exception {
        ExamDTORequest examDTORequest = ExamDTORequest.builder()
                .examName("Exame de Sangue")
                .build();

        ExamDTO createdExamDto = ExamDTO.builder()
                .id(1L)
                .examName("Exame de Sangue")
                .build();

        when(examService.create(any(ExamDTORequest.class))).thenReturn(createdExamDto);

        mockMvc.perform(post("/api/v1/exam")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(examDTORequest)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.examName").value("Exame de Sangue"));
    }

    @Test
    void devePermitirAtualizarExame() throws Exception {
        ExamDTORequest examDTORequest = ExamDTORequest.builder()
                .examName("Exame Atualizado")
                .build();

        ExamDTO updatedExamDto = ExamDTO.builder()
                .id(1L)
                .examName("Exame Atualizado")
                .build();

        when(examService.update(Mockito.eq(1L), any(ExamDTORequest.class))).thenReturn(Optional.of(updatedExamDto));

        mockMvc.perform(put("/api/v1/exam/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(examDTORequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.examName").value("Exame Atualizado"));
    }

    @Test
    void deveRetornarNotFoundAoAtualizarExameInexistente() throws Exception {
        ExamDTORequest examDTORequest = ExamDTORequest.builder()
                .examName("Exame Atualizado")
                .build();

        when(examService.update(Mockito.eq(2L), any(ExamDTORequest.class))).thenReturn(Optional.empty());

        mockMvc.perform(put("/api/v1/exam/2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(examDTORequest)))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Exam not found"));
    }

    @Test
    void devePermitirBuscarUmExamePeloId() throws Exception {
        ExamDTO examDto = ExamDTO.builder()
                .id(1L)
                .examName("Exame de Sangue")
                .build();

        when(examService.findById(1L)).thenReturn(Optional.of(examDto));

        mockMvc.perform(get("/api/v1/exam/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.examName").value("Exame de Sangue"));
    }

    @Test
    void deveRetornarNotFoundQuandoBuscarUmExameInexistente() throws Exception {
        when(examService.findById(2L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/v1/exam/2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Exam not found"));
    }

    @Test
    void devePermitirDeletarUmExame() throws Exception {
        when(examService.deleteById(1L)).thenReturn(true);

        mockMvc.perform(delete("/api/v1/exam/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Exam deleted successfully"));
    }

    @Test
    void deveRetornarNotFoundAoDeletarExameInexistente() throws Exception {
        when(examService.deleteById(2L)).thenReturn(false);

        mockMvc.perform(delete("/api/v1/exam/2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Exam not found"));
    }
}