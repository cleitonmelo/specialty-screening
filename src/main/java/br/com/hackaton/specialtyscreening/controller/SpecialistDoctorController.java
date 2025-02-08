package br.com.hackaton.specialtyscreening.controller;

import br.com.hackaton.specialtyscreening.controller.resources.BaseResource;
import br.com.hackaton.specialtyscreening.dto.SpecialistDoctorDTO;
import br.com.hackaton.specialtyscreening.dto.mappers.SpecialistDoctorMapper;
import br.com.hackaton.specialtyscreening.service.SpecialistDoctorService;
import br.com.hackaton.specialtyscreening.service.impl.SpecialistDoctorServiceImpl;
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
@RequestMapping("api/v1/specialists")
@Tag(name = "Manutenção de Médicos Especialistas",
        description = "API para gerenciamento de médicos especialistas")
public class SpecialistDoctorController extends BaseController {

    private final SpecialistDoctorService service;

    @Autowired
    public SpecialistDoctorController(SpecialistDoctorServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpecialistDoctorDTO> findById(@PathVariable("id") Long id) {
        SpecialistDoctorDTO dto = this.service.get(id);
        if ( dto == null ) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<BaseResource> create(@Valid @RequestBody SpecialistDoctorDTO dto){

        for (int i = 0; i < dto.specialties().stream().count(); i++) {
            Long value = dto.specialties().get(i).id();
            if ( ! this.service.isSpecialtyExists(value) ) {
                return this.badRequestException(HttpStatus.NOT_FOUND.name(),
                        "Especialidade com o código " + value.toString() + " não localizada");
            }
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(
                SpecialistDoctorMapper.toResource(this.service.save(dto))
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<SpecialistDoctorDTO> update(@Valid @RequestBody SpecialistDoctorDTO specialistDoctorDTO,
                                                      @PathVariable("id") Long id) {
        SpecialistDoctorDTO dto = this.service.get(id);
        if ( dto == null ) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(this.service.update(id, specialistDoctorDTO));
    }

    @GetMapping
    public ResponseEntity<Page<SpecialistDoctorDTO>> findAll(
            @ParameterObject
            @PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
         return ResponseEntity.ok().body(this.service.findAll(pageable));
    }
}
