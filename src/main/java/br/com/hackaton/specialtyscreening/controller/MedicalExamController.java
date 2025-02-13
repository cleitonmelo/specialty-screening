package br.com.hackaton.specialtyscreening.controller;

import br.com.hackaton.specialtyscreening.controller.resources.MedicalExamResource;
import br.com.hackaton.specialtyscreening.dto.MedicalExamDTO;
import br.com.hackaton.specialtyscreening.service.impl.MedicalExamServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/medical-exam")
@Tag(name = "Formulário de Triagem",
        description = "API para gerenciamento de cadastro de triagem de especialidades")
public class MedicalExamController extends BaseController {
    private final MedicalExamServiceImpl medicalExamService;

    @Autowired
    public MedicalExamController(MedicalExamServiceImpl medicalExamService) {
        this.medicalExamService = medicalExamService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<MedicalExamResource> getMedicalExam(@PathVariable Long id) {
        MedicalExamDTO medicalExamDTO = medicalExamService.get(id);
        MedicalExamResource MedicalExamResource = null;
        return ResponseEntity.ok(MedicalExamResource);
    }
}
