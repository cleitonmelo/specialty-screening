package br.com.hackaton.specialtyscreening.controller;

import br.com.hackaton.specialtyscreening.controller.resources.BaseResource;
import br.com.hackaton.specialtyscreening.controller.resources.ScreeningResource;
import br.com.hackaton.specialtyscreening.dto.DiagnosisDTO;
import br.com.hackaton.specialtyscreening.dto.ScreeningDTO;
import br.com.hackaton.specialtyscreening.dto.SpecialistDoctorDTO;
import br.com.hackaton.specialtyscreening.dto.SpecialtyDTO;
import br.com.hackaton.specialtyscreening.dto.mappers.ScreeningMapper;
import br.com.hackaton.specialtyscreening.model.Diagnosis;
import br.com.hackaton.specialtyscreening.service.DiagnosisService;
import br.com.hackaton.specialtyscreening.service.SpecialistDoctorService;
import br.com.hackaton.specialtyscreening.service.impl.ScreeningServiceImpl;
import br.com.hackaton.specialtyscreening.service.impl.SpecialtyServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/screening")
@Tag(name = "Formulário de Triagem",
        description = "API para gerenciamento de cadastro de triagem de especialidades")
public class ScreeningController extends BaseController{

    private final ScreeningServiceImpl screeningService;

    private final SpecialtyServiceImpl specialtyService;

    private final SpecialistDoctorService specialistDoctorService;

    private final DiagnosisService diagnosisService;

    @Autowired
    public ScreeningController(ScreeningServiceImpl screeningService, SpecialtyServiceImpl specialtyService, SpecialistDoctorService specialistDoctorService, DiagnosisService diagnosisService) {
        this.screeningService = screeningService;
        this.specialtyService = specialtyService;
        this.specialistDoctorService = specialistDoctorService;
        this.diagnosisService = diagnosisService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScreeningResource> findById(@PathVariable("id") Long id) {
        ScreeningDTO dto = this.screeningService.get(id);
        if ( dto == null ) {
            return ResponseEntity.notFound().build();
        }

        SpecialistDoctorDTO specialistDoctorService = null;
        if ( dto.specialistDoctor() != null ){
            specialistDoctorService = this.specialistDoctorService.get(dto.specialistDoctor());
        }

        SpecialtyDTO specialty = null;
        if ( dto.specialty() != null ){
            specialty = this.specialtyService.get(dto.specialty());
        }

        return ResponseEntity.ok().body(ScreeningMapper.toResource(this.screeningService.get(id),
                specialty,
                specialistDoctorService)
        );
    }

    @PostMapping
    public ResponseEntity<BaseResource> create(@Valid @RequestBody ScreeningDTO screeningDTO){
        if ( ! this.screeningService.isSpecialtyExists(screeningDTO.specialty()) ) {
            return this.badRequestException(HttpStatus.NOT_FOUND.name(),
                    "Especialidade não localizada para efetuar o cadastro!");
        }

        SpecialistDoctorDTO specialistDoctorService = null;
        if ( screeningDTO.specialistDoctor() != null ){
            specialistDoctorService = this.specialistDoctorService.get(screeningDTO.specialistDoctor());
        }

        SpecialtyDTO specialty = null;
        if ( screeningDTO.specialty() != null ){
            specialty = this.specialtyService.get(screeningDTO.specialty());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(
                ScreeningMapper.toResource(
                    this.screeningService.create(screeningDTO),
                        specialty, specialistDoctorService)
            );
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResource> update(@RequestBody ScreeningDTO screeningDTO,
                                                    @PathVariable("id") Long id)
    {
        ScreeningDTO dto = this.screeningService.get(id);
        if ( dto == null ) {
            return ResponseEntity.notFound().build();
        }

        if ( ! this.screeningService.isSpecialtyExists(screeningDTO.specialty()) ) {
            return this.badRequestException(HttpStatus.NOT_FOUND.name(),
                    "Especialidade não localizada para efetuar o cadastro!");
        }

        return ResponseEntity.ok().body(
                ScreeningMapper.toResource(
                        this.screeningService.update(screeningDTO),
                        this.specialtyService.get(dto.specialty()),
                        this.specialistDoctorService.get(dto.specialistDoctor())
                )
        );
    }

    @GetMapping
    public ResponseEntity<Page<ScreeningResource>> findScreeningBySpecialtyCode(
            @RequestParam("specialty_id") Long specialtyId,
            @ParameterObject
            @PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
         return ResponseEntity.ok().body(
                 this.screeningService.findAllBySpecialtyCode(specialtyId,pageable)
         );
    }

    @PutMapping("/{id}/associateSpecialists/{specialistId}")
    public ResponseEntity<BaseResource> associateSpecialists(@PathVariable("id") Long id,
                                                             @PathVariable("specialistId") Long specilistId) {

        if ( ! this.screeningService.isSpecialistExists(specilistId) )  {
            return this.badRequestException(HttpStatus.NOT_FOUND.name(),
                    "Especialista não localizado para associar ao formulário de triagem");
        }

        ScreeningDTO screeningDTO = this.screeningService.get(id);
        if ( screeningDTO == null ) {
            return ResponseEntity.notFound().build();
        }

        ScreeningResource resource = this.screeningService.associateSpecialist(specilistId, id);
        if ( resource == null ) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(resource);
    }

    @PostMapping("/{id}/diagnosis")
    public ResponseEntity<BaseResource> diagnosis(@PathVariable("id") Long id,
                                                  @RequestBody DiagnosisDTO dto) {

        Diagnosis diagnosis = this.diagnosisService.create(dto);
        if ( diagnosis == null ) {
            return this.badRequestException(HttpStatus.NOT_FOUND.name(),
                    "Ocorreu um erro ao criar um diagnostico");
        }
        return ResponseEntity.ok().body(this.screeningService.finishedDiagnosis(id, diagnosis));
    }
}
