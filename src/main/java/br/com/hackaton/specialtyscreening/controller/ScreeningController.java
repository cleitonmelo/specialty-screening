package br.com.hackaton.specialtyscreening.controller;

import br.com.hackaton.specialtyscreening.controller.resources.ScreeningResource;
import br.com.hackaton.specialtyscreening.dto.ScreeningDTO;
import br.com.hackaton.specialtyscreening.dto.mappers.ScreeningMapper;
import br.com.hackaton.specialtyscreening.service.impl.ScreeningServiceImpl;
import br.com.hackaton.specialtyscreening.service.impl.SpecialtyServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/screening")
@Tag(name = "Formulário de Triagem",
        description = "API para gerenciamento de cadastro de triagem de especialidades")
public class ScreeningController {

    private final ScreeningServiceImpl screeningService;

    private final SpecialtyServiceImpl specialtyService;

    @Autowired
    public ScreeningController(ScreeningServiceImpl screeningService, SpecialtyServiceImpl specialtyService) {
        this.screeningService = screeningService;
        this.specialtyService = specialtyService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScreeningResource> findById(@PathVariable("id") Long id) {
        ScreeningDTO dto = this.screeningService.get(id);
        if ( dto == null ) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(
                ScreeningMapper.toResource(this.screeningService.get(id),
                        this.specialtyService.get(dto.specialty())));
    }

    @PostMapping
    public ResponseEntity<ScreeningResource> create(@Valid @RequestBody ScreeningDTO screeningDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ScreeningMapper.toResource(
                    this.screeningService.create(screeningDTO),
                    this.specialtyService.get(screeningDTO.specialty())
            )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScreeningResource> update(@RequestBody ScreeningDTO screeningDTO,
                                                    @PathVariable("id") Long id)
    {
        ScreeningDTO dto = this.screeningService.get(id);
        if ( dto == null ) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(
                ScreeningMapper.toResource(
                        this.screeningService.update(screeningDTO),
                        this.specialtyService.get(dto.specialty())
                )
        );
    }

    @GetMapping
    public ResponseEntity<Page<ScreeningResource>> findScreeningBySpecialtyCode(
            @RequestParam("specialty_id") Long specialtyId, Pageable pageable){
         return ResponseEntity.ok().body(
                 this.screeningService.findAllBySpecialtyCode(specialtyId,pageable)
         );
    }

    @PutMapping("/{id}/associateSpecialists/{specialistId}")
    public ResponseEntity<ScreeningResource> associateSpecialists(@PathVariable("id") Long id,
                                                                  @PathVariable("specialistId") Long specilistId) {

        if ( this.screeningService.isSpecialistExists(specilistId) )  {
            return ResponseEntity.notFound().build();
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
}
